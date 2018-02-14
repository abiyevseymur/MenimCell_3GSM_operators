package com.example.seymur.azercell2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.nio.DoubleBuffer;

public class MBUsage extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private long mStartRX = 0;
    private long mStartTX = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbusage);
        mStartRX = TrafficStats.getTotalRxBytes();
        mStartTX = TrafficStats.getTotalTxBytes();
        if (mStartRX == TrafficStats.UNSUPPORTED || mStartTX == TrafficStats.UNSUPPORTED) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Uh Oh!");
            alert.setMessage("Your device does not support traffic stat monitoring.");
            alert.show();
        } else {
            mHandler.postDelayed(mRunnable, 1000);
        }
    }
    private final Runnable mRunnable = new Runnable() {
        @SuppressLint("SetTextI18n")
        public void run() {
            TextView RX = (TextView)findViewById(R.id.RX);
            TextView TX = (TextView)findViewById(R.id.TX);
            long rxBytes = (TrafficStats.getTotalRxBytes()- mStartRX)/100000;
            Double rxMB  = (double) rxBytes;
            RX.setText(Double.toString(rxMB/10));
            long txBytes = (TrafficStats.getTotalTxBytes()- mStartTX);
            TX.setText(Long.toString(rxBytes));
            mHandler.postDelayed(mRunnable, 1000);
        }
    };
}
