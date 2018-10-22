package pack.menimcellApp.seymur.azercell2.fragments.BakcellFragments;

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

import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;
import pack.menimcellApp.seymur.azercell2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RoamingB.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RoamingB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoamingB extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RoamingB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoamingB.
     */
    // TODO: Rename and change types and number of parameters
    public static RoamingB newInstance(String param1, String param2) {
        RoamingB fragment = new RoamingB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    Context context;
    Button activateRoaming;
    Button deactivateRoaming;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_roaming_b, container, false);
        context = getContext();
        activateRoaming = (Button) view.findViewById(R.id.activateRoamingBakcell);
        deactivateRoaming = (Button) view.findViewById(R.id.deactivateRoamingBakcell);
        activateRoaming.setOnClickListener(this);
        deactivateRoaming.setOnClickListener(this);
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
        switch (v.getId()) {
            case (R.id.activateRoamingAzercell):
                USSDcodes s = new USSDcodes();
                Intent intent = s.sendUssdCode(getString(R.string.ussdCodeRoamingActivate), getString(R.string.activateRoaming), context);
                startActivity(intent);
                break;
            case(R.id.deactivateRoamingAzercell):
                USSDcodes a = new USSDcodes();
                Intent intentA = a.sendUssdCode(getString(R.string.ussdCodeRoamingDeactivate), getString(R.string.deactivateRoaming), context);
                startActivity(intentA);
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
