package pack.menimcellApp.seymur.azercell2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import pack.menimcellApp.seymur.azercell2.fragments.Credit;
import pack.menimcellApp.seymur.azercell2.fragments.DigerMIP;
import pack.menimcellApp.seymur.azercell2.fragments.GundelikMIP;
import pack.menimcellApp.seymur.azercell2.fragments.InternetSettings;
import pack.menimcellApp.seymur.azercell2.fragments.Roaming;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.Gencsim;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.Tarif;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.TarifDoubleK;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.TariffDouble;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.TariffTelebe;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.tariffBolge;
import pack.menimcellApp.seymur.azercell2.fragments.Transfer;
import pack.menimcellApp.seymur.azercell2.fragments.VAS.CLIR_SOCLIR;
import pack.menimcellApp.seymur.azercell2.fragments.VAS.CallBarring;
import pack.menimcellApp.seymur.azercell2.fragments.VAS.CallForward;
import pack.menimcellApp.seymur.azercell2.fragments.VAS.CallScreening;
import pack.menimcellApp.seymur.azercell2.fragments.ayliqInternet;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
public class forFragments extends AppCompatActivity {
    Bundle extras;
    String serviceName;
    Fragment openFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragments);

        //Action Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        extras = getIntent().getExtras();
        if (extras != null) {
            serviceName = extras.getString("fragment");
        }
        if (serviceName != null) {
            if (serviceName.equals("azercellim")) {
                openFragment = new Tarif();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.azercellim);
            }
            if (serviceName.equals("gencol")) {
                openFragment = new TariffDouble();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.gencol);
            }
            if (serviceName.equals("bolge")) {
                openFragment = new tariffBolge();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.bolge);
            }
            if (serviceName.equals("gencsim")) {
                openFragment = new Gencsim();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.gencsim);
            }
            if (serviceName.equals("kombo")) {
                openFragment = new TarifDoubleK();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.kombo);
            }
            if (serviceName.equals("telebe")) {
                openFragment = new TariffTelebe();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.telebe);
            }
            if (serviceName.equals("mipAy")) {
                openFragment = new ayliqInternet();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.ayliqMip);
            }
            if (serviceName.equals("mipGun")) {
                openFragment = new GundelikMIP();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.gundelikMip);
            }
            if (serviceName.equals("mipDiger")) {
                openFragment = new DigerMIP();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.limitsizMip);
            }
            if (serviceName.equals("credit")) {
                openFragment = new Credit();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.credit);
            }
            if (serviceName.equals("transfer")) {
                openFragment = new Transfer();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.transfer);
            }
            if (serviceName.equals("roaming")) {
                openFragment = new Roaming();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.roaming);
            }
            if (serviceName.equals("internet")) {
                openFragment = new InternetSettings();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.internetSettings);
            }
            if (serviceName.equals("callforwarding")) {
                openFragment = new CallForward();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.callForwarding);
            }
            if (serviceName.equals("callbarring")) {
                openFragment = new CallBarring();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.callScreening);
            }
            if (serviceName.equals("callscreening")) {
                openFragment = new CallScreening();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.callScreening);
            }
            if (serviceName.equals("gizletcell")) {
                openFragment = new CLIR_SOCLIR();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayoutForFragments, openFragment).commit();
                getSupportActionBar().setTitle(R.string.gizlicellGizletcell);
            }

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}
