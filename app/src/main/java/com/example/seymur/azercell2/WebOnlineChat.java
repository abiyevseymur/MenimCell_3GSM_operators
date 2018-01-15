package com.example.seymur.azercell2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;


public class WebOnlineChat extends AppCompatActivity {
    private String url = "http://www.azercell.com/chat/chat_client.html#/history";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_online_chat);

        (findViewById(R.id.btnWebLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if (bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(),
                        "Onlayn " + bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
