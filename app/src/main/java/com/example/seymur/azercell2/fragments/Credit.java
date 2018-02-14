package com.example.seymur.azercell2.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.SendSMSTariff;
import com.example.seymur.azercell2.sendUSSDcode;

import static com.example.seymur.azercell2.R.color.pinkAcces;
import static com.example.seymur.azercell2.R.color.white;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Credit.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Credit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Credit extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Credit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Credit.
     */
    // TODO: Rename and change types and number of parameters
    public static Credit newInstance(String param1, String param2) {
        Credit fragment = new Credit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mContext = getApplicationContext();
    }

    public static Context getApplicationContext() {
        return mContext;
    }

    Button credit1azn;
    Button credit14azn;
    Button credit18azn;
    Button credit2azn;
    TextView checkDebts;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_credit, container, false);

        checkDebts = view.findViewById(R.id.checkDebts);
        checkDebts.setText(Html.fromHtml(getString(R.string.checkMyDebts)));

        ((BalanceMenu)getActivity()).showUpButton();

        credit1azn = view.findViewById(R.id.creditOneAznBtn);
        credit1azn.setOnClickListener(this);
        credit14azn = view.findViewById(R.id.creditOneFortyAznBtn);
        credit14azn.setOnClickListener(this);
        credit18azn = view.findViewById(R.id.creditOneEightyAznBtn);
        credit18azn.setOnClickListener(this);
        credit2azn = view.findViewById(R.id.creditwoAznBtn);
        credit2azn.setOnClickListener(this);
        checkDebts.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        checkDebts.setTextColor(getResources().getColor(white));
                        checkDebts.setBackgroundColor(getResources().getColor(pinkAcces));
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        checkDebts.setTextColor(getResources().getColor(pinkAcces));
                        checkDebts.setBackgroundColor(getResources().getColor(white));
                        break;
                    }
                }
                return false;
            }
        });
        checkDebts.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    String SimKreditDebts = "9150";
    String MaximumKreditDebts = "9155";
    String kreditTextDebts="Info";
    String Simkredit = "SimCredit";
    String Maximumkredit = "MaximumCredit";
    private Context context;
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.creditOneAznBtn):


                sendUssdCode(getString(R.string.ussdCodeOneAzn),getString(R.string.get),getString(R.string.creditOneAzn),getString(R.string.credit),
                    getString(R.string.creditOneAznFee),getString(R.string.fee));
                break;

            case (R.id.creditOneFortyAznBtn):
                sendUssdCode(getString(R.string.ussdCodeOneFortyAzn),getString(R.string.get),getString(R.string.creditOneFortyAzn),getString(R.string.credit),
                        getString(R.string.creditOneFortyAznFee),getString(R.string.fee));
                break;
            case (R.id.creditOneEightyAznBtn):
                sendUssdCode(getString(R.string.ussdCodeOneEightyAzn),getString(R.string.get),getString(R.string.creditOneEightyAzn),getString(R.string.credit),
                        getString(R.string.creditOneEightyAznFee),getString(R.string.fee));
                break;
            case (R.id.creditwoAznBtn):
                 sendUssdCode(getString(R.string.ussdCodeTwoAzn),getString(R.string.get),getString(R.string.creditTwoAzn),getString(R.string.credit),
                        getString(R.string.creditTwoAznFee),getString(R.string.fee));
                break;
            case (R.id.checkDebts):
                setSendPaycell(MaximumKreditDebts,kreditTextDebts,Maximumkredit);
                setSendPaycell(SimKreditDebts,kreditTextDebts,Simkredit);
                break;

        }
    }

    public void sendUssdCode(String USSDCode, String WillWhatWord, String numbOrPriceValue, String ThirdWord, String BeforeLastWord, String LastWord){
        Intent intent = new Intent(getActivity(), sendUSSDcode.class);
        Bundle b = new Bundle();
        b.putString("first", USSDCode);
        b.putString("messageTittle","You will"+" "+WillWhatWord+" "+numbOrPriceValue + " "+ ThirdWord + " "+ BeforeLastWord+ " "+ LastWord  );
        intent.putExtras(b);

        startActivity(intent);
    }
    public void setSendPaycell(String numb,String Text, String kreditType){
        Intent intent = new Intent(getActivity(), SendSMSTariff.class);
        Bundle b = new Bundle();
        b.putString("first", numb);
        b.putString("second",Text);
        b.putString("messageTittle",getString(R.string.learnMyDebts)  + " " + kreditType );
        intent.putExtras(b);
        startActivity(intent);
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
