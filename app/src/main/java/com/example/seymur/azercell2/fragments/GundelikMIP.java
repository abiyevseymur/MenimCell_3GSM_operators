package com.example.seymur.azercell2.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.ObjectClasses.USSDcodes;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GundelikMIP.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GundelikMIP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GundelikMIP extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GundelikMIP() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GundelikMIP.
     */
    // TODO: Rename and change types and number of parameters
    public static GundelikMIP newInstance(String param1, String param2) {
        GundelikMIP fragment = new GundelikMIP();
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
    Context context;
    String numb = "2525";
    String textSMS ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_gundelik_mi, container, false);
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }
        context = getContext();
        view.findViewById(R.id.daily50mb).setOnClickListener(this);
        view.findViewById(R.id.daily500mbAuto).setOnClickListener(this);
        view.findViewById(R.id.Daily500mbManual).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.daily50mb){
            USSDcodes s = new USSDcodes();
            Intent intent = s.sendUssdCode(getString(R.string.UssdCodeDailyFiftyMB),getString(R.string.get),getString(R.string.DailyFiftyMbA), context);
            startActivity(intent);
        }
        else if(v.getId() == R.id.daily500mbAuto){
            Intent intent = new Intent(getActivity(), SendSMSTariff.class);
            Bundle b = new Bundle();
            textSMS = "Gun+";
            //Add your data to bundle
            b.putString("first", numb);
            b.putString("second",textSMS);
            b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.DailyFifeHundredMB) +", " +getString(R.string.autoyeniletme) );
            intent.putExtras(b);
            startActivity(intent);
        }
        else if(v.getId() == R.id.Daily500mbManual){
            Intent intent = new Intent(getActivity(), SendSMSTariff.class);
            Bundle b = new Bundle();
            //Add your data to bundle
            textSMS = "Gun";
            b.putString("first", numb);
            b.putString("second",textSMS);
            b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.DailyFifeHundredMB) + ", "+getString(R.string.OneTimeMB));
            intent.putExtras(b);
            startActivity(intent);
        }

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
