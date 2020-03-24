package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context;
    TextView helloText;
    EditText textInput;
    EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloText = (TextView) findViewById(R.id.helloText);
        context = MainActivity.this;
        System.out.println("Folder location: " + context.getFilesDir());
        fileName = (EditText) findViewById(R.id.fileName);

        // Source https://stackoverflow.com/questions/42862942/how-to-invoke-a-method-on-textview-when-text-is-changed
        textInput = (EditText) findViewById(R.id.inputText);
        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                helloText.setText(textInput.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {
                helloText.setText(textInput.getText());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

        });

    }

    public void helloWorldButton(View v) {
        System.out.println("Hello world!");
        helloText.setText("Hello world!");
    }

    public void readFile(View v) {
        try {
            String readBuffer = "";
            String finalizedString = "";
            String file = fileName.getText().toString();

            InputStream in = context.openFileInput(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            while ((readBuffer = br.readLine()) != null) {
                if(finalizedString.length() < 1) {
                    finalizedString = finalizedString + readBuffer;
                } else {
                    finalizedString = finalizedString +"\n" + readBuffer;
                }

            }
            textInput.setText(finalizedString);
            in.close();
        } catch (IOException e) {
            Log.e("IOException","Something went wrong! Does the file exists?");
        }
    }

    public void writeFile(View v) {
        try {
            String lineToWrite = textInput.getText().toString();
            String file = fileName.getText().toString();

            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
            ows.write(lineToWrite);
            ows.close();
        } catch (IOException e) {
            Log.e("IOException","Something went wrong! Does the file exists?");
        }
    }

}
