package com.example.seymur.azercell2.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.ObjectClasses.USSDcodes;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DigerMIP.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DigerMIP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DigerMIP extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DigerMIP() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DigerMIP.
     */
    // TODO: Rename and change types and number of parameters
    public static DigerMIP newInstance(String param1, String param2) {
        DigerMIP fragment = new DigerMIP();
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
    TextView Unlim1H;
    TextView Unlim3H;
    TextView UnlimNight;
    TextView Unlim1Week;
    String numb = "2525";
    String textSMS = "Gece";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_diger_mi, container, false);
        context = getContext();
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }
        view.findViewById(R.id.unlimitedOneHour).setOnClickListener(this);
        view.findViewById(R.id.unlimitedThreeHour).setOnClickListener(this);
        view.findViewById(R.id.unlimitedWeekend).setOnClickListener(this);
        view.findViewById(R.id.unlimitedNight).setOnClickListener(this);

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

            if (v.getId() == R.id.unlimitedOneHour) {
                USSDcodes s = new USSDcodes();
                Intent intent = s.sendUssdCode(getString(R.string.UssdCodeOneH),  getString(R.string.get), getString(R.string.unlimOneH), getString(R.string.unlimfortyQ), context);
                startActivity(intent);
            }
            else if(v.getId() == R.id.unlimitedThreeHour){
                USSDcodes s = new USSDcodes();
                Intent intent  = s.sendUssdCode(getString(R.string.UssdCodethreeH) , getString(R.string.get),getString(R.string.unlimThreeH),getString(R.string.unlimOneAzn),context);
                startActivity(intent);
            }
            else if(v.getId() == R.id.unlimitedWeekend) {
                USSDcodes s = new USSDcodes();
                Intent intent  = s.sendUssdCode(getString(R.string.UssdCodeWeekend) ,getString(R.string.get),getString(R.string.UnlimWeekend), getString(R.string.unlimOneTwoAzn),getString(R.string.fromFriday),getString(R.string.tillSunday),getString(R.string.maxSpeed),context);
                startActivity(intent);
            }
            else if(v.getId() == R.id.unlimitedNight) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.unlimNight) + " - "+getString(R.string.unlimNintyNineAzn) + ", "+ getString(R.string.fromZerotillEight));
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
