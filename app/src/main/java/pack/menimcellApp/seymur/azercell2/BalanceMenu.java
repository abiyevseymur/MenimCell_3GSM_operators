package pack.menimcellApp.seymur.azercell2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import pack.menimcellApp.seymur.azercell2.fragments.BalanceNew;
import pack.menimcellApp.seymur.azercell2.fragments.Xidmetler;


public class BalanceMenu extends AppCompatActivity implements View.OnClickListener {
    final String TAG = "cycle";
    Xidmetler fxidmetler;
    BalanceNew fbalance;
    ImageView logoSettings;
    int mainLogo;
    String projectToken = "5908ccdb281d509b82825cb12f81f7a8"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"

  /*  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
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
        }*/

    


    //back button
/*
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

/*
    public void showUpButton() {
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideUpButton() {
        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
*/

    MixpanelAPI mixpanel;
    BalanceNew firstFragment;
    String NetworkCarrierName = "None";
    static String phoneNumber;
    Context mContext;
    Button AzercellBtn;
    Button BakcellBtn;
    Button NarBtn;
    TextView Privacy;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    String MIXPANEL_TOKEN = "5908ccdb281d509b82825cb12f81f7a8";
    @SuppressLint("HardwareIds")
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_menu);
        mContext = getApplicationContext();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Google ADS
        MobileAds.initialize(mContext, "ca-app-pub-5793905217254232~2047872944");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        // code for testing "ca-app-pub-3940256099942544/6300978111"
        //ads Full Screen
    /*    mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5793905217254232/7823098985");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });*/

        //test add
        // mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        //

        // Create Frist fragment here:
        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        // Add the fragment to the 'fragment_container' FrameLayout

        AzercellBtn = (Button)findViewById(R.id.azercelbtn);
        AzercellBtn.setOnClickListener(this);
        BakcellBtn = (Button)findViewById(R.id.bakcellbtn);
        BakcellBtn.setOnClickListener(this);
        NarBtn = (Button)findViewById(R.id.narbtn);
        NarBtn.setOnClickListener(this);
        Privacy = (TextView)findViewById(R.id.PrivacyP);
        Privacy.setOnClickListener(this);

        fxidmetler = new Xidmetler();
        fbalance = new BalanceNew();

        mContext = getApplicationContext();
//        mixpanel.getPeople().identify(trackingDistinctId); //this is the distinct_id
//        // that will be used for people analytics. You must set this explicitly in order
//        // to dispatch people data.

        /*firstFragment = new BalanceNew();
        firstFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();*/


        //bottom menu size
/*        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
        }*/
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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if(getSupportActionBar() != null)
       /* mainLogo = R.drawable.ic_action_bar_logo;
        AppLogo(mainLogo);
        setSupportActionBar(myToolbar);

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
                getSupportActionBar().setDisplayShowTitleEnabled(true);

                getSupportActionBar().setTitle("  " +  getString(R.string.noAnyNumb)  );
        }
        //*/
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
        //MixPanelCode event
        MixpanelAPI mixpanel =
                MixpanelAPI.getInstance(mContext, MIXPANEL_TOKEN);
        try {
            JSONObject props = new JSONObject();
            props.put("PhoneNumber", (phoneNumber.trim()));

            mixpanel.track("PhoneNumber", props);
        }
        catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
        //
        //

    }

/*
    public void AppLogo(int logo) {
        if(getSupportActionBar() != null){
            getSupportActionBar().setLogo(logo);
        }
    }*/


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


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.azercelbtn){
            Intent intent = new Intent(this, MenimAzercell.class);
            startActivity(intent);
            // for full screen ads
              /*  if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }*/
        }
        if (v.getId() == R.id.bakcellbtn){
            Intent intent = new Intent(this, MenimNar.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.narbtn){
            Intent intent = new Intent(this, MenimNar.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.PrivacyP){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://menimcell.com/Privacy-Policy/"));
            startActivity(i);
        }
    }
}
