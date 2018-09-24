package pack.menimcellApp.seymur.azercell2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MenimNar extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menim_nar);
        TextView text = (TextView) findViewById(R.id.fbtittle);
        text.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fbtittle) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://bit.ly/2G5Xana/"));
            startActivity(i);
        }
    }
}
