package com.example.week9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

//Todo: Country selection not implemented. Not required for Object oriented programming exercise 9.4, for only 9.5.
//Todo: Pickup time not implemented. Not required for Object oriented programming exercise 9.4, only for 9.5. Also would only work with Estonia data.

public class MainActivity extends AppCompatActivity {

    private TextView informationBox;
    private int[] visitingDate = new int[] {1,1,100};
    private int[] openingTime = new int[] {0,1};
    private int[] closingTime = new int[] {0,0};
    private TextView visitingDateText;
    private TextView openingTimeText;
    private TextView closingTimeText;
    private Spinner locations;
    private SmartPostStorage storageObject;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        context = MainActivity.this;

        informationBox = (TextView) findViewById(R.id.informationText);

        visitingDateText = (TextView) findViewById(R.id.dateText);
        openingTimeText = (TextView) findViewById(R.id.openingTimeText);
        closingTimeText = (TextView) findViewById(R.id.closingTimeText);

        storageObject = SmartPostStorage.getInstance();
        storageObject.downloadData();

        locations = (Spinner) findViewById(R.id.locationSpinner);
        ArrayAdapter smartPostLocationsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, storageObject.getSmartPostLocations());
        smartPostLocationsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locations.setAdapter(smartPostLocationsAdapter);



        locations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the value selected by the user
                // e.g. to store it as a field or immediately call a method
                SmartPost location = (SmartPost) parent.getSelectedItem();
                informationBox.setText(location.displayInformation());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Dummy adapter for country selection.
        Spinner countries = (Spinner) findViewById(R.id.countrySpinner);
        ArrayAdapter countriesAA = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"Finland", "Estonia", "All"} );
        countriesAA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countries.setAdapter(countriesAA);

    }

    public void datePicker (View v){
        int mYear, mMonth, mDay;

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        System.out.println(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        visitingDate = new int[]{dayOfMonth, (monthOfYear), year};
                        visitingDateText.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void openingTimePicker(View v) {
        int mHour, mMinute;
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        System.out.println(hourOfDay + ":" + minute);
                        openingTime = new int[]{hourOfDay, minute};
                        openingTimeText.setText(String.format("%02d:%02d%n", hourOfDay, minute));
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

    public void closingTimePicker(View v) {
        int mHour, mMinute;
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        System.out.println(hourOfDay + ":" + minute);
                        closingTime = new int[]{hourOfDay, minute};
                        closingTimeText.setText(String.format("%02d:%02d%n", hourOfDay, minute));
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

    public void applyFilter (View v) {
        ArrayList<SmartPost> filteredList = storageObject.filterData(visitingDate, openingTime, closingTime);
        ArrayAdapter smartPostLocationsAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, filteredList );
        smartPostLocationsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locations.setAdapter(smartPostLocationsAdapter);
    }

    public void resetFilter (View v) {

        ArrayAdapter smartPostLocationsAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, storageObject.getSmartPostLocations() );
        smartPostLocationsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locations.setAdapter(smartPostLocationsAdapter);
    }

}

