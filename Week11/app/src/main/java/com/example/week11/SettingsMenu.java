package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsMenu extends AppCompatActivity {

    private DataTransferSingleton data = DataTransferSingleton.getInstance();
    private CheckBox box;
    private Spinner sizeSpinner;
    private Spinner colorSpinner;
    private Spinner styleSpinner;
    private Spinner backgroundSpinner;
    private Spinner linesSpinner;
    private Spinner languagesSpinner;

    private String[] sizes = {"8", "10", "12", "16", "20", "24"};
    private String[] colors = {"White", "Black", "Indigo", "Scarlet"};
    private String[] styles = {"Normal", "Bold", "Italic", "Bold Italic"};
    private String[] backColor = {"Silver", "Gold", "White", "Aquamarine"};
    private String[] lines = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] languages = {"English", "Finnish", "Swedish"};
    private String[] colorsHex = {"#FFFFFF", "#000000", "#4B0082", "#FF2400"};
    private String[] backColorHex = {"#C0C0C0", "#FFD700", "#FFFFFF", "#7FFFD4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
        box = (CheckBox) findViewById(R.id.checkBox);
        EditText displayText = (EditText) findViewById(R.id.userInput);

        sizeSpinner = (Spinner) findViewById(R.id.textSize);
        colorSpinner = (Spinner) findViewById(R.id.textColor);
        styleSpinner = (Spinner) findViewById(R.id.textStyle);
        backgroundSpinner = (Spinner) findViewById(R.id.backgroundColor);
        linesSpinner = (Spinner) findViewById(R.id.numberOfLines);
        languagesSpinner = (Spinner) findViewById(R.id.languagesSpinner);



        ArrayAdapter aaSize = new ArrayAdapter(this,android.R.layout.simple_spinner_item, sizes);
        ArrayAdapter aaColor = new ArrayAdapter(this,android.R.layout.simple_spinner_item, colors);
        ArrayAdapter aaStyle = new ArrayAdapter(this,android.R.layout.simple_spinner_item, styles);
        ArrayAdapter aaBackGrnd= new ArrayAdapter(this,android.R.layout.simple_spinner_item, backColor);
        ArrayAdapter aaLines = new ArrayAdapter(this,android.R.layout.simple_spinner_item, lines);
        ArrayAdapter aaLanguages = new ArrayAdapter(this,android.R.layout.simple_spinner_item, languages);

        aaSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaStyle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaBackGrnd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaLines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aaLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sizeSpinner.setAdapter(aaSize);
        colorSpinner.setAdapter(aaColor);
        styleSpinner.setAdapter(aaStyle);
        backgroundSpinner.setAdapter(aaBackGrnd);
        linesSpinner.setAdapter(aaLines);
        languagesSpinner.setAdapter(aaLanguages);


        // Spinner event listeners
        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int size = Integer.parseInt(parent.getItemAtPosition(position).toString());
                data.setTextSize(size);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                switch (color) {
                    case "White":
                        data.setTextColor("#FFFFFF");
                        break;
                    case "Black":
                        data.setTextColor("#000000");
                        break;
                    case "Indigo":
                        data.setTextColor("#4B0082");
                        break;
                    case "Scarlet":
                        data.setTextColor("#FF2400");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + color);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        styleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String style = parent.getItemAtPosition(position).toString();
                switch (style) {
                    case "Normal":
                        data.setTextStyle(0);
                        break;
                    case "Bold":
                        data.setTextStyle(1);
                        break;
                    case "Italic":
                        data.setTextStyle(2);
                        break;
                    case "Bold Italic":
                        data.setTextStyle(3);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + style);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        backgroundSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String bColor = parent.getItemAtPosition(position).toString();
                switch (bColor) {
                    case "Silver":
                        data.setBackgroundColor("#C0C0C0");
                        break;
                    case "Gold":
                        data.setBackgroundColor("#FFD700");
                        break;
                    case "White":
                        data.setBackgroundColor("#FFFFFF");
                        break;
                    case "Aquamarine":
                        data.setBackgroundColor("#7FFFD4");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + bColor);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        linesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int lines = Integer.parseInt(parent.getItemAtPosition(position).toString());
                data.setLineNumber(lines);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        languagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data.setLanguage(parent.getItemAtPosition(position).toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        displayText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                data.setTextDisplay(s.toString());
            }
        });

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        data.setTextEditable(checked);
    }

    public void goBack(View v) {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        box.setChecked(data.isTextEditable());

        String textSize = String.valueOf(data.getTextSize());
        sizeSpinner.setSelection(java.util.Arrays.asList(sizes).indexOf(textSize));
        linesSpinner.setSelection(data.getLineNumber() - 1);

        colorSpinner.setSelection(java.util.Arrays.asList(colorsHex).indexOf(data.getTextColor()));
        styleSpinner.setSelection(data.getTextStyle());
        backgroundSpinner.setSelection(java.util.Arrays.asList(backColorHex).indexOf(data.getBackgroundColor()));

        languagesSpinner.setSelection(java.util.Arrays.asList(languages).indexOf(data.getLanguage()));
    }
}
