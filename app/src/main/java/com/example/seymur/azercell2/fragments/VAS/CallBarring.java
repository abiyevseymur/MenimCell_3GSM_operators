package com.example.seymur.azercell2.fragments.VAS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.CheckBox;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.sendUSSDcode;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CallBarring.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CallBarring#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallBarring extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CallBarring() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallBarring.
     */
    // TODO: Rename and change types and number of parameters
    public static CallBarring newInstance(String param1, String param2) {
        CallBarring fragment = new CallBarring();
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
    CheckBox incomingCalls;
    CheckBox incomingSMS;
    CheckBox outgoingCalls;
    CheckBox outgoingSMS;
    Button ActivateCB;
    Button DeactivateCB;
    EditText PasswordCB;
    //All barring codes
    String incomingCBCallsAc = "*35*";
    String incomingCBSMSAc = "*35*";
    String outgoingCBCallsAc = "*33*";
    String outgoingCBSMSAc = "*33*";
    String incomingCBCallsDeac = "#35*";
    String incomingCBSMSDeac = "#35*";
    String outgoingCBCallsDeac = " #33*";
    String outgoingCBSMSDeac = "#33*";
    String CBSMSonly = "*16";
    //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call_barring, container, false);
        ((BalanceMenu) getActivity()).showUpButton();
        incomingCalls = (CheckBox)view.findViewById(R.id.incomingCalls);
        incomingSMS = (CheckBox) view.findViewById(R.id.incomingSMS);
        outgoingCalls = (CheckBox)view.findViewById(R.id.outgoingCalls);
        outgoingSMS = (CheckBox)view.findViewById(R.id.outgoingSMS);
        ActivateCB = (Button)view.findViewById(R.id.activateCallBarring);
        DeactivateCB = (Button)view.findViewById(R.id.deactivateCallBarring);
        PasswordCB = (EditText)view.findViewById(R.id.passwordCallBarring);
        ActivateCB.setOnClickListener(this);
        DeactivateCB.setOnClickListener(this);
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
            case(R.id.activateCallBarring):
                if(incomingCalls.isChecked()){
                    sendUssdCode(incomingCBCallsAc + PasswordCB.getText().toString(),getString(R.string.Activate),getString(R.string.barringTo), getString(R.string.AllIncoming),getString(R.string.Calls),"");
                }
                else if(incomingSMS.isChecked()){
                    sendUssdCode(incomingCBSMSAc + PasswordCB.getText().toString() + CBSMSonly,getString(R.string.Activate),getString(R.string.barringTo), getString(R.string.AllIncoming),getString(R.string.sms),"");
                }
                else if(outgoingCalls.isChecked()){
                    sendUssdCode(outgoingCBCallsAc + PasswordCB.getText().toString() + CBSMSonly,getString(R.string.Activate),getString(R.string.barringTo), getString(R.string.AllOutgoing),getString(R.string.Calls),"");
                }
                else if(outgoingSMS.isChecked()){
                    sendUssdCode(outgoingCBSMSAc + PasswordCB.getText().toString(),getString(R.string.Activate),getString(R.string.barringTo), getString(R.string.AllOutgoing),getString(R.string.sms),"");
                }
                break;
            case(R.id.deactivateCallBarring):
                if(incomingCalls.isChecked()){
                    sendUssdCode(incomingCBCallsDeac + PasswordCB.getText().toString(),getString(R.string.deaktive),getString(R.string.barringTo), getString(R.string.AllIncoming),getString(R.string.Calls),"");
                }
                else if(incomingSMS.isChecked()){
                    sendUssdCode(incomingCBSMSDeac + PasswordCB.getText().toString() + CBSMSonly,getString(R.string.deaktive),getString(R.string.barringTo), getString(R.string.AllIncoming),getString(R.string.sms),"");
                }
                else if(outgoingCalls.isChecked()){
                    sendUssdCode(outgoingCBCallsDeac + PasswordCB.getText().toString(),getString(R.string.deaktive),getString(R.string.barringTo), getString(R.string.AllOutgoing),getString(R.string.Calls),"");
                }
                else if(outgoingSMS.isChecked()){
                    sendUssdCode(outgoingCBSMSDeac + PasswordCB.getText().toString() + CBSMSonly,getString(R.string.deaktive),getString(R.string.barringTo), getString(R.string.AllOutgoing),getString(R.string.sms),"");
                }
                else{

                }
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
