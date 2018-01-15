package com.example.seymur.azercell2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Seymur on 17/12/23.
 */

public class sendUSSDcode extends AppCompatActivity {
    Button SendUssdCode;
    Button cancelUssdCode;
    Bundle bundle;
    String ussdCode;
    String messageBundle;
    TextView messageTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smstariff);
        bundle = getIntent().getExtras();
        ussdCode = bundle.getString("first");
        messageBundle = bundle.getString("messageTittle");

        messageTittle = (TextView) findViewById(R.id.youSure);
        messageTittle.setText(messageBundle);
        SendUssdCode = (Button) findViewById(R.id.SendSmstarrif);

        SendUssdCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my_callIntent;
                my_callIntent = new Intent(Intent.ACTION_CALL);
                my_callIntent.setData(Uri.parse("tel:" + ussdCode.trim() + Uri.encode("#")));

                if (ActivityCompat.checkSelfPermission(sendUSSDcode.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(my_callIntent);
                finish();
            }
        });
        cancelUssdCode = (Button) findViewById(R.id.SendSmstarrifCancel);
        cancelUssdCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
