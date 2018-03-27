package com.example.seymur.azercell2.ObjectClasses;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.sendUSSDcode;

public class USSDcodes {

    public Intent sendUssdCode(String USSDCode, String Message , Context context){
        Intent intent = new Intent(context, sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle",context.getString(R.string.YouWill)+" "+ Message );
        intent.putExtras(b);

        return intent;
    }
    public Intent sendUssdCode(String USSDCode, String Message ,String MessageTwo, Context context){
        Intent intent = new Intent(context, sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle",context.getString(R.string.YouWill)+" "+ Message +" "+ MessageTwo );
        intent.putExtras(b);

        return intent;
    }
    public Intent sendUssdCode(String USSDCode, String Message ,String MessageTwo,String MessageThree, Context context){
        Intent intent = new Intent(context, sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle",context.getString(R.string.YouWill)+" "+ Message+" "+ MessageTwo +" "+ MessageThree  );
        intent.putExtras(b);

        return intent;
    }
    public Intent sendUssdCode(String USSDCode, String Message ,String MessageTwo,String MessageThree,String MessageFour, Context context){
        Intent intent = new Intent(context, sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle",context.getString(R.string.YouWill)+" "+ Message+" "+ MessageTwo +" "+ MessageThree +" "+ MessageFour  );
        intent.putExtras(b);

        return intent;
    }
    public Intent sendUssdCode(String USSDCode, String Message, String MessageTwo, String MessageThree, String MessageFour, String MesageFive, Context context){
        Intent intent = new Intent(context, sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle",context.getString(R.string.YouWill)+" "+ Message+" "+ MessageTwo +" "+ MessageThree +" "+ MessageFour +" "+ MesageFive  );
        intent.putExtras(b);

        return intent;
    }
    public Intent sendUssdCode(String USSDCode, String Message, String MessageTwo, String MessageThree, String MessageFour, String MesageFive,String MessageSix, Context context){
        Intent intent = new Intent(context, sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle",context.getString(R.string.YouWill)+" "+ Message+" "+ MessageTwo +" "+ MessageThree +" "+ MessageFour +" "+ MesageFive +" "+ MessageSix  );
        intent.putExtras(b);

        return intent;
    }
}
