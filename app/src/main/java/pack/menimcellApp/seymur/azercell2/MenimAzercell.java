package pack.menimcellApp.seymur.azercell2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pack.menimcellApp.seymur.azercell2.fragments.BalanceNew;
import pack.menimcellApp.seymur.azercell2.fragments.Xidmetler;

public class MenimAzercell extends AppCompatActivity {
    private TabLayout tablayoutAz;
    private ViewPager viewpagerAz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menim_azercell);
        tablayoutAz = (TabLayout)findViewById(R.id.tablayoutAz_id);
        viewpagerAz = (ViewPager)findViewById(R.id.viewpageraz_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new BalanceNew(), getString(R.string.title_Xidmetler));
        adapter.AddFragment(new Xidmetler(), getString(R.string.tarifler));

        //set adapter
        viewpagerAz.setAdapter(adapter);
        tablayoutAz.setupWithViewPager(viewpagerAz);
    }
}
