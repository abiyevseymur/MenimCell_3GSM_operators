package com.example.seymur.azercell2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Seymur on 17/09/10.
 */
public class VerifyCode extends AppCompatActivity implements View.OnClickListener {
    final String TAG = "cycle";
    TextView textView6;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        Log.d(TAG, "cycle onCreate");

        textView6 = (TextView) findViewById(R.id.textView6);
        Intent intent = getIntent();
        String name =  intent.getStringExtra("nomre");
        textView6.setText(name);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(VerifyCode.this,BalanceMenu.class);
        startActivity(intent);
    }

}
