package pack.menimcellApp.seymur.azercell2;

import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import pack.menimcellApp.seymur.azercell2.fragments.ServVasBak;
import pack.menimcellApp.seymur.azercell2.fragments.XidmetlerBakcell;

public class MenimBakcell extends AppCompatActivity {
    private TabLayout tablayoutAz;
    private ViewPager viewpagerAz;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menim_bakcell);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tablayoutAz = (TabLayout)findViewById(R.id.tablayoutAz_id);
        viewpagerAz = (ViewPager)findViewById(R.id.viewpageraz_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new ServVasBak(), getString(R.string.title_Xidmetler));
        adapter.AddFragment(new XidmetlerBakcell(), getString(R.string.tarifler));

        //set adapter
        viewpagerAz.setAdapter(adapter);
        tablayoutAz.setupWithViewPager(viewpagerAz);

        //set adapter
        viewpagerAz.setAdapter(adapter);
        tablayoutAz.setupWithViewPager(viewpagerAz);
        ///ads google
        MobileAds.initialize(this, "ca-app-pub-5793905217254232~2047872944");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //
    }
}
