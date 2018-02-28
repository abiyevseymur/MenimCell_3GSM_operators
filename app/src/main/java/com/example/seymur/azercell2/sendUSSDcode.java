package com.example.seymur.azercell2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Seymur on 17/12/23.
 */

public class sendUSSDcode extends AppCompatActivity implements View.OnClickListener {
    Button SendUssdCode;
    Button cancelUssdCode;
    Bundle bundle;
    String ussdCode;
    String messageBundle;
    TextView messageTittle;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 0;

    private boolean clicked ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smstariff);
        bundle = getIntent().getExtras();
        assert bundle != null;
        ussdCode = bundle.getString("first");
        messageBundle = bundle.getString("messageTittle");
        messageTittle = (TextView) findViewById(R.id.youSure);
        messageTittle.setText(messageBundle);
        SendUssdCode = (Button) findViewById(R.id.SendSmstarrif);
        SendUssdCode.setOnClickListener(this);
        cancelUssdCode = (Button) findViewById(R.id.SendSmstarrifCancel);
        cancelUssdCode.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the phone call
                    startUSSD();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void startUSSD() {
        clicked = true;
        Intent my_callIntent;
        my_callIntent = new Intent(Intent.ACTION_CALL);
        my_callIntent.setData(Uri.parse("tel:" + ussdCode.trim() + Uri.encode("#")));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(my_callIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.SendSmstarrif):

                if (ActivityCompat.checkSelfPermission(sendUSSDcode.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(sendUSSDcode.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);

                    return;
                } else {
                    //You already have permission
                    try {

                        startUSSD();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }

                finish();

                break;
            case (R.id.SendSmstarrifCancel):
                clicked = false;
                finish();
                break;

        }

    }

    public boolean isClicked() {
        return clicked;
    }
}
