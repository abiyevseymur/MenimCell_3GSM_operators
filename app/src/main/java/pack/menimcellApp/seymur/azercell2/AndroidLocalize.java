package pack.menimcellApp.seymur.azercell2;

import android.app.Activity;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Created by Seymur on 18/01/23.
 */
public class AndroidLocalize extends Activity {

    public void setLocale(String lang) {


        String languageToLoad  = "en"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }}
