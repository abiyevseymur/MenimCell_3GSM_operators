package pack.menimcellApp.seymur.azercell2.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.sendUSSDcode;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Roaming.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Roaming#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Roaming extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Roaming() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Roaming newInstance(String param1, String param2) {
        Roaming fragment = new Roaming();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    Button SendUssdCode;
    Button cancelUssdCode;
    Context context;
    Switch Roaming;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_roaming, container, false);
        SendUssdCode = (Button) view.findViewById(R.id.SendSmstarrif);
        cancelUssdCode = (Button) view.findViewById(R.id.SendSmstarrifCancel);
        context =getContext();

        Roaming = (Switch)view.findViewById(R.id.RoamingSwitchBtn);
        Roaming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    USSDcodes s = new USSDcodes();
                    Intent intent = s.sendUssdCode(getString(R.string.activateRoamingUSSD),getString(R.string.activateRoaming),context);
                    startActivity(intent);
                    sendUSSDcode a = new sendUSSDcode();
       /*             if(!a.clicked){
                        Roaming.setChecked(false);
                    }*/


                }
                else{
                    sendUSSDcode a = new sendUSSDcode();
                    USSDcodes s = new USSDcodes();
                    Intent intent = s.sendUssdCode(getString(R.string.deactivateRoamingUSSD),getString(R.string.deactivateRoaming),context);
                    startActivity(intent);
                    if(!a.isClicked()){
                        Roaming.setChecked(true);
                    }
                    Roaming.setChecked(false);





                }
            }
        });

        //checked but not really work
      /*  final TelephonyManager tm = (TelephonyManager)getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            PhoneStateListener phoneStateListener = new PhoneStateListener() {
                @Override
                public void onServiceStateChanged(ServiceState serviceState) {
                    super.onServiceStateChanged(serviceState);
                    if (tm.isNetworkRoaming()) {
                        Toast.makeText(context, "Roaming is On a", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Roaming is OFF a", Toast.LENGTH_LONG).show();
                    }
                    // You can also check roaming state using this
                    if (serviceState.getRoaming()) {
                        Toast.makeText(context, "Roaming is On service", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Roaming is Off service", Toast.LENGTH_LONG).show();

                    }
                }
            };*/
//        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
    /*    check roaming only for new version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            List<SubscriptionInfo> subscriptions = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
            for (SubscriptionInfo subscriptionInfo:subscriptions) {
                if (subscriptionInfo.getDataRoaming() == SubscriptionManager.DATA_ROAMING_ENABLE) {
                    Toast.makeText(context, "Roaming is On", Toast.LENGTH_LONG).show();
                }
            }
            Toast.makeText(context, "Roaming is OFF", Toast.LENGTH_LONG).show();
        }*/
      /*  NetworkInfo ni = null;
        if (cm != null) {
            ni = cm.getActiveNetworkInfo();
        }*/
 /*
        Do not worked!

        if (ni != null) {
            if (tm != null) {
                if ( tm.isNetworkRoaming() || ni.isRoaming()){
                    Toast.makeText(context, "Roaming is On", Toast.LENGTH_LONG).show();
                }
                else if(!ni.isRoaming()){
                    Toast.makeText(context, "Roaming is OFF", Toast.LENGTH_LONG).show();

                }
            }
        }*/

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
