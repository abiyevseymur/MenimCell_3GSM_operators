package com.example.seymur.azercell2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
=======
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
>>>>>>> 5231f67325196afa0ebaf041b8ba95cb67756817
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.seymur.azercell2.fragments.BalanceNew;

import java.util.Locale;

import io.paperdb.Paper;

/**
 * Created by Seymur on 18/01/23.
 */

<<<<<<< HEAD
public class AndroidLocalize extends Activity {


=======
public class AndroidLocalize extends AppCompatActivity {
    Spinner spinnerctrl;
    Locale myLocale;
>>>>>>> 5231f67325196afa0ebaf041b8ba95cb67756817

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
=======
        setContentView(R.layout.setting_lang);
       //Action Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.settings);

        spinnerctrl = (Spinner) findViewById(R.id.spinner1);
        spinnerctrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                if (pos == 1) {

                    Toast.makeText(parent.getContext(),
                            "You have selected Russian", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("ru");
                } else if (pos == 2) {

                    Toast.makeText(parent.getContext(),
                            "You have selected Azerbaijani", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("az");
                } else if (pos == 3) {

                    Toast.makeText(parent.getContext(),
                            "You have selected English", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");
                }

            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
    }

    public void setLocale(String lang) {
>>>>>>> 5231f67325196afa0ebaf041b8ba95cb67756817

        String languageToLoad  = "en"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }}
