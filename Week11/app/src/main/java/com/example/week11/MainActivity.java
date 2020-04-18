package com.example.week11;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

/* ####################################
Following tutorial used for side menu: https://www.youtube.com/watch?v=VD3YItr9nMg
#######################################
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView textBox1;
    private TextView textBox2;
    private EditText textInput;
    private DataTransferSingleton data = DataTransferSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textBox1 = (TextView) findViewById(R.id.text1);
        textBox2 = (TextView) findViewById(R.id.text2);
        textInput = (EditText) findViewById(R.id.editText2);

        textBox1.setText(data.getTextFromInputBox());
        textInput.setText("You can write here.");
        textBox2.setText(data.getTextDisplay());


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();
                if (menuItem.toString().equals("Settings")) {
                    Intent intent = new Intent(MainActivity.this, SettingsMenu.class);
                    startActivity(intent);
                }
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here
                return true;
            }
        });
        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                data.setTextFromInputBox(s.toString());
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateTexts();
    }

    private void updateTexts() {

        switch (data.getTextStyle()) {
            case 0:
                textBox1.setTypeface(null, Typeface.NORMAL);
                break;
            case 1:
                textBox1.setTypeface(null, Typeface.BOLD);
                break;
            case 2:
                textBox1.setTypeface(null, Typeface.ITALIC);
                break;
            case 3:
                textBox1.setTypeface(null, Typeface.BOLD_ITALIC);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + data.getTextStyle());
        }
        textBox1.setBackgroundColor(Color.parseColor(data.getBackgroundColor()));
        textBox1.setTextColor(Color.parseColor(data.getTextColor()));
        textBox1.setTextSize(data.getTextSize());
        textBox1.setLines(data.getLineNumber());
        if (data.isTextEditable()) {
            textInput.setFocusableInTouchMode(true);
        } else {
            textInput.setFocusable(false);
            textBox1.setText(data.getTextFromInputBox());
        }
        textBox2.setText(data.getTextDisplay());

    }
// 0 = normal, 1 = Bold, 2 = Italic, 3 = Bold Italic

}


