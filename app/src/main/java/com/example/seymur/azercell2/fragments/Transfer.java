package com.example.seymur.azercell2.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.R;
import com.example.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Transfer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Transfer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Transfer extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Transfer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Transfer.
     */
    // TODO: Rename and change types and number of parameters
    public static Transfer newInstance(String param1, String param2) {
        Transfer fragment = new Transfer();
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
    EditText nomrePaycell;
    Button sendPaycell;
    RadioButton check20q;
    RadioButton check50q;
    RadioButton check1azn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_transfer, container, false);
        ((BalanceMenu)getActivity()).showUpButton();
        nomrePaycell = (EditText)view.findViewById(R.id.transferPhoneNumb);
        check20q = (RadioButton) view.findViewById(R.id.send20q);
        check50q = (RadioButton) view.findViewById(R.id.send50q);
        check1azn = (RadioButton) view.findViewById(R.id.send1azn);
        sendPaycell = (Button) view.findViewById(R.id.sendPaycell);
        sendPaycell.setOnClickListener(this);

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
    String numbOf20qPaycell = "9204";
    String numbOf50qPaycell = "9200";
    String numbOf1aznPaycell = "9202";
    String textMessage;
    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.sendPaycell) {

                if (nomrePaycell.getText().toString().trim().length() == 10 ){
                    if (check20q.isChecked()) {
                        textMessage = check20q.getText().toString();
                        setSendPaycell(numbOf20qPaycell);
                    }else if(check50q.isChecked()){
                        textMessage = check50q.getText().toString();
                        setSendPaycell(numbOf50qPaycell);
                    }
                    else if(check1azn.isChecked()){
                        textMessage = check1azn.getText().toString();
                        setSendPaycell(numbOf1aznPaycell);
                    }
                    else{
                        Toast.makeText(getActivity(), R.string.HowMuchToast,Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(), R.string.pleaseEnterFullNumb,Toast.LENGTH_SHORT).show();
                }
        }
    }
//
    public void setSendPaycell(String amount){
        Intent intent = new Intent(getActivity(), SendSMSTariff.class);
        Bundle b = new Bundle();
        b.putString("first", amount);
        b.putString("second",nomrePaycell.getText().toString());
        b.putString("messageTittle","The amount "+ textMessage + "fee, will be send to " + nomrePaycell.getText().toString() + " Number" );
        intent.putExtras(b);

        startActivity(intent);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
