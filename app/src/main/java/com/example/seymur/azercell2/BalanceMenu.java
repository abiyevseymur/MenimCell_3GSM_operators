package com.example.seymur.azercell2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;

import com.example.seymur.azercell2.Helper.LocaleHelper;
import com.example.seymur.azercell2.map.MapsActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import android.app.usage.NetworkStats;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.TrafficStats;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.util.Log;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seymur.azercell2.fragments.*;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import io.paperdb.Paper;

import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.TrafficStats.getMobileRxBytes;
import static android.net.TrafficStats.getMobileRxPackets;
import static java.lang.System.currentTimeMillis;


public class BalanceMenu extends AppCompatActivity {
    final String TAG = "cycle";
    ServicesVAS fxercler;
    Xidmetler fxidmetler;
    BalanceNew fbalance;
    Ayar fayar;
    ImageView logoSettings;
    int mainLogo;
    String projectToken = "5908ccdb281d509b82825cb12f81f7a8"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem  item) {
            FragmentTransaction ftrans;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ftrans = getSupportFragmentManager().beginTransaction();
                    getSupportFragmentManager().popBackStack();
                    ftrans.replace(R.id.fragment_container, fbalance);
                    ftrans.commit();

                    return true;
                case R.id.navigation_xidmetler:
                    ftrans = getSupportFragmentManager().beginTransaction();
                    getSupportFragmentManager().popBackStack();
                    ftrans.replace(R.id.fragment_container, fxidmetler);
                    ftrans.commit();
                    return true;
                case R.id.navigation_xercler:
                    ftrans = getSupportFragmentManager().beginTransaction();
                    getSupportFragmentManager().popBackStack();
                    ftrans.replace(R.id.fragment_container, fxercler);
                    ftrans.commit();
                    return true;
                case R.id.navigation_ayar:
                    ftrans = getSupportFragmentManager().beginTransaction();
                    getSupportFragmentManager().popBackStack();
                    ftrans.replace(R.id.fragment_container, fayar);
                    ftrans.commit();
                    return true;

            }
            return false;
        }

    };


    //back button

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showUpButton() {
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideUpButton() {
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    MixpanelAPI mixpanel;
    BalanceNew firstFragment;
    String NetworkCarrierName = "None";
    static String phoneNumber;
    private Context mContext;

    private AdView mAdView;
    @SuppressLint("HardwareIds")
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_menu);
        mContext = getApplicationContext();

        //Google ADS
        MobileAds.initialize(mContext, "ca-app-pub-3940256099942544/6300978111");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("34807B4D4FB6E3663C310659FF76B41D")
                .build();
        mAdView.loadAd(adRequest);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        //
        // Create Frist fragment here:
        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        // Add the fragment to the 'fragment_container' FrameLayout

//        final String trackingDistinctId = getTrackingDistinctId();
//
        fxidmetler = new Xidmetler();
        fbalance = new BalanceNew();
        fxercler = new ServicesVAS();
        fayar = new Ayar();
        mContext = getApplicationContext();
//        mixpanel.getPeople().identify(trackingDistinctId); //this is the distinct_id
//        // that will be used for people analytics. You must set this explicitly in order
//        // to dispatch people data.

        firstFragment = new BalanceNew();
        firstFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();


        //bottom menu size
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            // set your height here
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, displayMetrics);
            // set your width here

            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
        //
        //Action Toolbar
        TelephonyManager tManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (tManager != null) {
            phoneNumber = tManager.getLine1Number();
        }
        String carrierName = null;
        if (tManager != null) {
            carrierName = tManager.getNetworkOperator();
        }
        //
/*        logoSettings = (ImageView)findViewById(R.id.logoSettings);
        logoSettings.setOnClickListener(this);*/
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if(getSupportActionBar() != null)
        mainLogo = R.drawable.ic_action_bar_logo;
        AppLogo(mainLogo);


        //Azercell
        if(Objects.equals(carrierName, "40001")&& phoneNumber!=null){
            if(getSupportActionBar() != null)

                getSupportActionBar().setTitle("  " + phoneNumber);
            NetworkCarrierName = "Azercell";
        }

        //Bakcell
        else if(Objects.equals(carrierName, "40002") && phoneNumber!=null){
            if(getSupportActionBar() != null)

                getSupportActionBar().setTitle("  " + phoneNumber);
            NetworkCarrierName= "Bakcell";
        }
        //Nar
        else if(Objects.equals(carrierName, "40004")&& phoneNumber!=null){
            if(getSupportActionBar() != null)

                getSupportActionBar().setTitle("  " + phoneNumber);
            NetworkCarrierName = "Nar";
        }
        //other
        else {
            if(getSupportActionBar() != null)

                getSupportActionBar().setTitle("  " +  getString(R.string.noAnyNumb)  );
        }
        //
        //Mix Panel Token
        //mixpanel.identify(phoneNumber); //this is the distinct_id value that
        // will be sent with events. If you choose not to set this,
        // the SDK will generate one for you

        mixpanel = MixpanelAPI.getInstance(this, projectToken);
        //mix panel JSON

        mixpanel.getPeople().identify(phoneNumber);
        mixpanel.getPeople().initPushHandling("767485387864");
        mixpanel.getPeople().set("$name",phoneNumber);
        mixpanel.getPeople().set("$Carrier_Name", NetworkCarrierName);
        mixpanel.getPeople().set("$Update Date", new Date());

        //

    }


    public void AppLogo(int logo) {
        if(getSupportActionBar() != null)

            getSupportActionBar().setLogo(logo);
    }


    //phone number

    public static String PhoneNumber(){
        return  phoneNumber;
    };

    private static final String MIXPANEL_DISTINCT_ID_NAME = "Mixpanel Example $distinctid";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"BottomMenu onStart");
    }

    @Override
    protected void onResume() {
        mAdView.resume();
        super.onResume();

        Log.d(TAG, "BottomMenu onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "BottomMenu onRestart");
    }

    @Override
    protected void onPause() {
        mAdView.pause();
        super.onPause();

        Log.d(TAG, "BottomMenu onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "BottomMenu onStop");
    }

    @Override
    protected void onDestroy() {
        mAdView.destroy();
        super.onDestroy();
        Log.d(TAG, "BottomMenu onDestroy");
    }


}
