package com.example.seymur.azercell2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.fragments.VAS.CLIR_SOCLIR;
import com.example.seymur.azercell2.fragments.VAS.CallBarring;
import com.example.seymur.azercell2.fragments.VAS.CallForward;
import com.example.seymur.azercell2.fragments.VAS.CallScreening;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ServicesVAS.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ServicesVAS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServicesVAS extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ServicesVAS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicesVAS.
     */
    // TODO: Rename and change types and number of parameters
    public static ServicesVAS newInstance(String param1, String param2) {
        ServicesVAS fragment = new ServicesVAS();
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
        fCallForwarding = new CallForward();
        fCallbarring = new CallBarring();
        fCallScreening = new CallScreening();
        fClirSoclir = new CLIR_SOCLIR();
    }
    CallForward fCallForwarding;
    ImageButton CallForwarding;
    CallBarring fCallbarring;
    ImageButton Callbarring;
    CallScreening fCallScreening;
    ImageButton CallScreening;
    CLIR_SOCLIR fClirSoclir;
    ImageButton ClirSoclir;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services_vas, container, false);
        if(getActivity() != null)

        ((BalanceMenu)getActivity()).hideUpButton();
        CallForwarding = (ImageButton) view.findViewById(R.id.callForwardMain);
        Callbarring = (ImageButton)view.findViewById(R.id.CallBarring);
        CallScreening = (ImageButton)view.findViewById(R.id.CallScreening);
        ClirSoclir = (ImageButton)view.findViewById(R.id.ClirAndSoclir);
        ClirSoclir.setOnClickListener(this);
        CallScreening.setOnClickListener(this);
        CallForwarding.setOnClickListener(this);
        Callbarring.setOnClickListener(this);
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
        switch (v.getId()){
            case(R.id.callForwardMain):
                FragmentTransaction ft = this.getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,fCallForwarding,"e");
                ft.addToBackStack("e");
                ft.commit();
                break;
            case(R.id.CallBarring):
                FragmentTransaction ftm = this.getFragmentManager().beginTransaction();
                ftm.replace(R.id.fragment_container,fCallbarring,"e");
                ftm.addToBackStack("e");
                ftm.commit();
                break;
            case(R.id.CallScreening):
                FragmentTransaction ftCB = this.getFragmentManager().beginTransaction();
                ftCB.replace(R.id.fragment_container,fCallScreening,"e");
                ftCB.addToBackStack("e");
                ftCB.commit();
                break;
            case(R.id.ClirAndSoclir):
                FragmentTransaction ftCS = this.getFragmentManager().beginTransaction();
                ftCS.replace(R.id.fragment_container,fClirSoclir,"e");
                ftCS.addToBackStack("e");
                ftCS.commit();
                break;
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
