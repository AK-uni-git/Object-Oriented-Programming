package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottleDispenser bottleDispenser = BottleDispenser.getInstance();

    private  ArrayList<String> soda = null;
    private  String[] size = { "1.5L", "0.5L", "0.3L"};
    private  TextView moneyInput;
    private  TextView output;
    private float moneyToBeAdded = 0;
    private TextView moneyIndicator;
    private String selectedBottle;
    private String selectedVolume;
    private Context context;
    private String receiptToWrite;
    private EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        fillDispenser(bottleDispenser);
        soda = bottleDispenser.generateListOfUniqueBottleNames();

        moneyInput = (TextView) findViewById(R.id.moneyText);
        output = (TextView) findViewById(R.id.consoleWindow);
        output.setMovementMethod(new ScrollingMovementMethod());
        output.setText(bottleDispenser.listBottles());
        moneyIndicator = (TextView) findViewById(R.id.moneyIndicator);
        moneyIndicator.setText(String.format("Current balance: %.2f€", bottleDispenser.getMoney() ));
        fileName = (EditText) findViewById(R.id.fileNameforReceipt);


        // https://www.javatpoint.com/android-spinner-example
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner sodaSpinner = (Spinner) findViewById(R.id.bottle);
        Spinner sizeSpinner = (Spinner) findViewById(R.id.size);

        //Creating the ArrayAdapter instance having the soda list
        ArrayAdapter aaSoda = new ArrayAdapter(this,android.R.layout.simple_spinner_item, soda);
        aaSoda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sodaSpinner.setAdapter(aaSoda);


        ArrayAdapter aaSize = new ArrayAdapter(this,android.R.layout.simple_spinner_item, size);
        aaSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sizeSpinner.setAdapter(aaSize);

        sodaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(parent.getItemAtPosition(position).toString());
                selectedBottle = parent.getItemAtPosition(position).toString();
            }


            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(parent.getItemAtPosition(position).toString());
                selectedVolume = parent.getItemAtPosition(position).toString();
            }


            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        SeekBar seekBarMoney = (SeekBar) findViewById(R.id.seekBar);
        moneyToBeAdded = (float)  seekBarMoney.getProgress() / 10;
        moneyInput.setText(String.format("Money to be added: %.2f€", moneyToBeAdded) );
        seekBarMoney.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                moneyToBeAdded = (float)  seekBar.getProgress() / 10;
                moneyInput.setText(String.format("Money to be added: %.2f€", moneyToBeAdded) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                moneyToBeAdded = (float)  seekBar.getProgress() / 10;
                moneyInput.setText(String.format("Money to be added: %.2f€", moneyToBeAdded) );

            }
        });
    }



    public void handleMoneyButton (View v) {
        output.setText(bottleDispenser.addMoney(moneyToBeAdded));
        moneyIndicator.setText(String.format("Current balance: %.2f€", bottleDispenser.getMoney() ));
    }

    public void handleBottlesButton (View v) {
        output.setText(bottleDispenser.listBottles());
    }

    public void handleReturnMoneyButton (View v) {
        output.setText(bottleDispenser.returnMoney());
        moneyIndicator.setText(String.format("Current balance: %.2f€", bottleDispenser.getMoney() ));
    }

    public void handleBuyButton (View v) {
        System.out.println("BUY WAS PRESSED");
        Bottle sodaToBuy = bottleDispenser.getBottle(selectedBottle, selectedVolume);
        if(sodaToBuy == null) {
            output.setText("Bottle '" + selectedBottle + "' with a volume of '" + selectedVolume + "' is not available.\nPlease select correct bottle from the list.");
            System.out.println("NULL WAS RETURNED");
            return;
        } else {
            output.setText(bottleDispenser.buyBottle(sodaToBuy));
            System.out.println("BOTTLE WAS BOUGHT");
            moneyIndicator.setText(String.format("Current balance: %.2f€", bottleDispenser.getMoney() ));
            receiptToWrite = "Receipt for bottle dispenser.\nYou bought one '" + sodaToBuy.getName() + "' with a volume of '" + sodaToBuy.getVolume() + "' and at the price of '" + sodaToBuy.getPrice() + "'\n\nThank you for your purchase and buy again.";
        }
    }

    public void writeReceipt(View v) {
        try {
            System.out.println("FOLDER!" );
            System.out.println(context.getFilesDir().toString() );
            String file = fileName.getText().toString();

            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
            ows.write(receiptToWrite);
            ows.close();
        } catch (IOException e) {
            Log.e("IOException","Something went wrong! Does the file exists?");
        }
    }
    private void fillDispenser(BottleDispenser dispenser) {
        dispenser.addBottle("Pepsi Max", "Pepsi", "0.3", "0.5L", 1.8f);
        dispenser.addBottle("Pepsi Max", "Pepsi", "0.9", "1.5L", 2.2f);
        dispenser.addBottle("Coca-Cola Zero", "Coca Cola Company", "0.3", "0.5L", 2.0f);
        dispenser.addBottle("Coca-Cola Zero", "Coca Cola Company", "0.9", "1.5L", 2.5f);
        dispenser.addBottle("Fanta Zero", "Coca Cola Company", "0.3", "0.5L", 1.95f);
        dispenser.addBottle("Jaffa", "Oy Hartwall Ab", "37", "1.5L", 2.5f);
        dispenser.addBottle("Jaffa", "Oy Hartwall Ab", "37", "0.5L", 1.75f);
        dispenser.addBottle("Coca-Cola", "Coca Cola Company", "41", "1.5L", 2.5f);
        dispenser.addBottle("Coca-Cola", "Coca Cola Company", "41", "0.3L", 1.5f);

    }
}
