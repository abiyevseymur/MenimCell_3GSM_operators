package com.example.seymur.azercell2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;

import com.example.seymur.azercell2.Helper.LocaleHelper;
import com.example.seymur.azercell2.map.MapsActivity;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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

import com.example.seymur.azercell2.fragments.*;

import java.util.Date;
import java.util.Objects;
import java.util.Random;


public class BalanceMenu extends AppCompatActivity implements View.OnClickListener {
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
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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

    /*@Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }*/

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideUpButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    MixpanelAPI mixpanel;
    BalanceNew firstFragment;
    String NetworkCarrierName = "None";
    static String phoneNumber;
    private Context mContext;
    @SuppressLint("HardwareIds")
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_menu);
        // Create Frist fragment here:
        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        // Add the fragment to the 'fragment_container' FrameLayout
        final String trackingDistinctId = getTrackingDistinctId();

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
        logoSettings = (ImageView)findViewById(R.id.logoSettings);
        logoSettings.setOnClickListener(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mainLogo = R.drawable.ic_action_bar_logo;
        AppLogo(mainLogo);


        //Azercell
        if(Objects.equals(carrierName, "40001")&& phoneNumber!=null){
            getSupportActionBar().setTitle("  " + phoneNumber);
            NetworkCarrierName = "Azercell";
        }

        //Bakcell
        else if(Objects.equals(carrierName, "40002") && phoneNumber!=null){
            getSupportActionBar().setTitle("  " + phoneNumber);
            NetworkCarrierName= "Bakcell";
        }
        //Nar
        else if(Objects.equals(carrierName, "40004")&& phoneNumber!=null){
            getSupportActionBar().setTitle("  " + phoneNumber);
            NetworkCarrierName = "Nar";
        }
        //other
        else {
            getSupportActionBar().setTitle("  " + getString(R.string.noAnyNumb));
        }
        //
        //Mix Panel Token
//        mixpanel.identify(phoneNumber); //this is the distinct_id value that
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
        //
        fxidmetler = new Xidmetler();
        fbalance = new BalanceNew();
        fxercler = new ServicesVAS();
        fayar = new Ayar();
    }

    public void AppLogo(int logo) {
        getSupportActionBar().setLogo(logo);
    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
    }

    private String generateDistinctId() {
        final Random random = new Random();
        final byte[] randomBytes = new byte[32];
        random.nextBytes(randomBytes);
        return Base64.encodeToString(randomBytes, Base64.NO_WRAP | Base64.NO_PADDING);
}
    private String getTrackingDistinctId() {
        final SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String ret = prefs.getString(MIXPANEL_DISTINCT_ID_NAME, null);
        if (ret == null) {
            ret = generateDistinctId();
            final SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putString(MIXPANEL_DISTINCT_ID_NAME, ret);
            prefsEditor.apply();
        }

        return ret;
    }

    public static String PhoneNumber(){
        return  phoneNumber;
    };

    private static final String MIXPANEL_DISTINCT_ID_NAME = "Mixpanel Example $distinctid";
    @Override
    protected void onStart() {
        super.onStart();
        getPrefs();
        Log.d(TAG,"BottomMenu onStart");
    }

    @Override
    protected void onResume() {
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
        super.onDestroy();
        Log.d(TAG, "BottomMenu onDestroy");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.logoSettings):
                Intent intent = new Intent(this, AndroidLocalize.class);
                startActivity(intent);
        }
    }
    boolean CheckboxPreference;
    String ListPreference;
    String editTextPreference;
    String ringtonePreference;
    String secondEditTextPreference;
    String customPref;

    private void getPrefs() {
        // Get the xml/preferences.xml preferences
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        CheckboxPreference = prefs.getBoolean("checkboxPref", true);
        ListPreference = prefs.getString("listPref", "nr1");
        editTextPreference = prefs.getString("editTextPref",
                "Nothing has been entered");
        ringtonePreference = prefs.getString("ringtonePref",
                "DEFAULT_RINGTONE_URI");
        secondEditTextPreference = prefs.getString("SecondEditTextPref",
                "Nothing has been entered");
        // Get the custom preference
        SharedPreferences mySharedPreferences = getSharedPreferences(
                "myCustomSharedPrefs", Activity.MODE_PRIVATE);
        customPref = mySharedPreferences.getString("myCusomPref", "");
    }
}
