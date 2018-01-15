package com.example.seymur.azercell2;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Balance extends AppCompatActivity implements View.OnClickListener {
    Button buttonNomre;
    EditText editTexNomre;
    final String TAG = "cyrcle";
    int realNumb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        buttonNomre = (Button) findViewById(R.id.buttonNomre);
        buttonNomre.setOnClickListener(this);

        editTexNomre = (EditText) findViewById(R.id.editTextNomre);
        realNumb = editTexNomre.getText().toString().trim().length();
        Log.d(TAG, "Balance onCreate");

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNomre:
                if (editTexNomre.getText().toString().trim().length() > 8){
                    Intent intentC = new Intent(this, BalanceMenu.class);
                    intentC.putExtra("nomre",editTexNomre.getText().toString());
                    startActivity(intentC);
                    finish();
                    break;
                }
                else{
                    Toast.makeText(this, R.string.PleaseEnteryourN,
                            Toast.LENGTH_LONG).show();
                }

        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Balance onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Balance onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Balance onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Balance onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Balance onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Balance onDestroy");
    }

}
