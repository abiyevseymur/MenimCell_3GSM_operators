package com.example.seymur.azercell2;

import android.app.Application;
import android.content.Context;

import com.example.seymur.azercell2.Helper.LocaleHelper;

/**
 * Created by Seymur on 18/01/22.
 */

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }

}
