package com.example.seymur.azercell2.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ayliqInternet.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ayliqInternet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ayliqInternet extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ayliqInternet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ayliqInternet.
     */
    // TODO: Rename and change types and number of parameters
    public static ayliqInternet newInstance(String param1, String param2) {
        ayliqInternet fragment = new ayliqInternet();
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

    // NUMBER AND SMS
    String numb = "2525";
    String MIP50 = "50";
    String MIP500 = "500";
    String MIP1000 = "1000";
    String MIP5000 = "5000";
    String MIP10000 = "10000";
    String MIPU = "L";
    String textSMS;
    //

    Button mip50;
    Button mip500;
    Button mip1000;
    Button mip5000;
    Button mip10000;
    Button mipLimitsiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ayliq_internet, container, false);
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }
        mip50 = (Button) view.findViewById(R.id.mip50);
        mip50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                textSMS = MIP50;
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.mipFiftyPrice));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        //
        mip500 = (Button) view.findViewById(R.id.mip500);
        mip500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                textSMS = MIP500;
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.mipfiveHundredPrice));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        mip1000 = (Button) view.findViewById(R.id.mip1000);
        mip1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                textSMS = MIP1000;
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.mipOneGbPrice));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        mip5000 = (Button) view.findViewById(R.id.mip5000);
        mip5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                textSMS = MIP5000;
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.mipFiveGbPrice));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        mip10000 = (Button) view.findViewById(R.id.mip10000);
        mip10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                textSMS = MIP10000;
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.mipTenGbPrice));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        mipLimitsiz = (Button) view.findViewById(R.id.mipLimitsiz);
        mipLimitsiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                //Add your data to bundle
                textSMS = MIPU;
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.thePriceOf) + " " + getString(R.string.mipUnlimitPrice));
                intent.putExtras(b);
                startActivity(intent);
            }
        });

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
