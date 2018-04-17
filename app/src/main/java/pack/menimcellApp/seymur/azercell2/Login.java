package pack.menimcellApp.seymur.azercell2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pack.menimcellApp.seymur.azercell2.R;


public class Login extends AppCompatActivity implements View.OnClickListener {
    final String TAG = "cyrcle";
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        TelephonyManager tManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        if (tManager != null) {
            String carrierName = tManager.getNetworkOperatorName();
        }

        Intent intent;
//        if(carrierName.equals("SimSim")){
            intent = new Intent(Login.this,BalanceMenu.class);
            startActivity(intent);
            finish();
//        }
        /*else{
            customLayout("Please, Insert Azercell (SimSim) SIM Card!");
        }*/

                //write a code

        Log.d(TAG,"Login onCreate");
    }

    public void customLayout(String name) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(name);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 10, 40);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Login onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Login onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Login onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Login onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Login onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Login onDestroy");
    }
}
