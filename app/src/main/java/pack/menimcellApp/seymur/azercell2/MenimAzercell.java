package pack.menimcellApp.seymur.azercell2;

import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import pack.menimcellApp.seymur.azercell2.fragments.BalanceNew;
import pack.menimcellApp.seymur.azercell2.fragments.Xidmetler;
import com.google.android.gms.ads.MobileAds;

public class MenimAzercell extends AppCompatActivity {
    private TabLayout tablayoutAz;
    private ViewPager viewpagerAz;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menim_azercell);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tablayoutAz = (TabLayout)findViewById(R.id.tablayoutAz_id);
        viewpagerAz = (ViewPager)findViewById(R.id.viewpageraz_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new BalanceNew(), getString(R.string.title_Xidmetler));
        adapter.AddFragment(new Xidmetler(), getString(R.string.tarifler));

        //set adapter
        viewpagerAz.setAdapter(adapter);
        tablayoutAz.setupWithViewPager(viewpagerAz);
        ///ads google
        MobileAds.initialize(this, "ca-app-pub-5793905217254232~2047872944");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice("34807B4D4FB6E3663C310659FF76B41D")
//                .build();
//        mAdView.loadAd(adRequest);
        //
    }
}
