package pack.menimcellApp.seymur.azercell2.fragments.VAS;

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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CallForward.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CallForward#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallForward extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CallForward() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallForward.
     */
    // TODO: Rename and change types and number of parameters
    public static CallForward newInstance(String param1, String param2) {
        CallForward fragment = new CallForward();
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
    EditText CallforwardingNumber;
    Button callForwardActive;
    Button callForwardDeactive;
    RadioButton callForwardingAll;
    RadioButton callForwardingBusy;
    RadioButton callForwardingNoAnswer;
    RadioButton CallForwardingOff;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call_forward, container, false);
        context = getContext();
        if (((BalanceMenu) getActivity()) != null) {
            ((BalanceMenu) getActivity()).showUpButton();
        }
        CallforwardingNumber = (EditText) view.findViewById(R.id.callforwardPhoneNumb);
        callForwardingAll = (RadioButton) view.findViewById(R.id.AllCallsForwarding);
        callForwardingBusy = (RadioButton) view.findViewById(R.id.callforwardingBusy);
        callForwardingNoAnswer = (RadioButton) view.findViewById(R.id.CallForwardingNotAnswered);
        CallForwardingOff = (RadioButton) view.findViewById(R.id.callForwardingSwitchedOff);
        callForwardActive = (Button) view.findViewById(R.id.activeCallForwarding);
        callForwardDeactive = (Button) view.findViewById(R.id.deactiveCallForwarding);
        callForwardActive.setOnClickListener(this);
        callForwardDeactive.setOnClickListener(this);
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


    String textMessage;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.activeCallForwarding):
                if (CallforwardingNumber.getText().toString().trim().length() == 13) {
                    if (callForwardingAll.isChecked()) {
                        textMessage = callForwardingAll.getText().toString();
                        USSDcodes s = new USSDcodes();
                       Intent intent  = s.sendUssdCode(getString(R.string.CFallCallsUSSD) + CallforwardingNumber.getText().toString(), getString(R.string.forward), textMessage, getString(R.string.toThis), CallforwardingNumber.getText().toString(),
                                getString(R.string.number),context);
                       startActivity(intent);
                    } else if (callForwardingBusy.isChecked()) {
                        textMessage = callForwardingBusy.getText().toString();
                        USSDcodes s = new USSDcodes();
                        Intent intent = s.sendUssdCode(getString(R.string.CFbussyUSSD) + CallforwardingNumber.getText().toString(), getString(R.string.forward), textMessage, getString(R.string.toThis), CallforwardingNumber.getText().toString(),
                                getString(R.string.number),context);
                        startActivity(intent);
                    } else if (callForwardingNoAnswer.isChecked()) {
                        textMessage = callForwardingNoAnswer.getText().toString();
                        USSDcodes s = new USSDcodes();
                       Intent intent = s.sendUssdCode(getString(R.string.CFNoAnswUSSD) + CallforwardingNumber.getText().toString(), getString(R.string.forward), textMessage, getString(R.string.toThis), CallforwardingNumber.getText().toString(),
                                getString(R.string.number),context);
                       startActivity(intent);
                    } else if (CallForwardingOff.isChecked()) {
                        textMessage = CallForwardingOff.getText().toString();
                        USSDcodes s = new USSDcodes();
                        Intent intent = s.sendUssdCode(getString(R.string.CFoffUSSD) + CallforwardingNumber.getText().toString(), getString(R.string.forward), textMessage, getString(R.string.toThis), CallforwardingNumber.getText().toString(),
                                getString(R.string.number),context);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), R.string.switchtypeofForwarding, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), R.string.pleaseEnterFullNumb, Toast.LENGTH_SHORT).show();
                }

                break;
            case (R.id.deactiveCallForwarding):
                USSDcodes u = new USSDcodes() ;
                Intent intent = u.sendUssdCode( getString(R.string.CFdeactiveUSSD), getString(R.string.deaktive), "", getString(R.string.allTypesofCF),getString(R.string.inYour),
                                getString(R.string.number),context);
                startActivity(intent);
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
