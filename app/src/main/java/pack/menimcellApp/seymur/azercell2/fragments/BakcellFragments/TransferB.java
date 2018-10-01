package pack.menimcellApp.seymur.azercell2.fragments.BakcellFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;
import pack.menimcellApp.seymur.azercell2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TransferB.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TransferB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransferB extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TransferB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransferB.
     */
    // TODO: Rename and change types and number of parameters
    public static TransferB newInstance(String param1, String param2) {
        TransferB fragment = new TransferB();
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
    RadioButton check20qB;
    RadioButton check6aznB;
    RadioButton check1aznB;
    String textMessage;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_transfer_b, container, false);
        nomrePaycell = (EditText) view.findViewById(R.id.transferPhoneNumb);
        nomrePaycell.setInputType(InputType.TYPE_CLASS_PHONE);
        check20qB = (RadioButton) view.findViewById(R.id.send20qB);
        check6aznB = (RadioButton) view.findViewById(R.id.send6aznB);
        check1aznB = (RadioButton) view.findViewById(R.id.send1aznB);
        sendPaycell = (Button) view.findViewById(R.id.sendPaycell);
        sendPaycell.setOnClickListener(this);
        context = getContext();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onClick(View view) {

        if (view.getId()==R.id.sendPaycellB) {

            if (nomrePaycell.getText().toString().trim().length() == 10 ){
                if (check20qB.isChecked()) {
                    textMessage = check20qB.getText().toString();
                    USSDcodes ussdA = new USSDcodes();
                    Intent intent = ussdA.sendUssdCode(getString(R.string.ussdCodeMoneyTransferB)+nomrePaycell.getText().toString() + getString(R.string.ussdCodeTwentyQepikBEnd),getString(R.string.send),getString(R.string.amount),textMessage,getString(R.string.willbesent),
                            nomrePaycell.getText().toString(),getString(R.string.numb),context);
                    startActivity(intent);
                }else if(check6aznB.isChecked()){
                    textMessage = check6aznB.getText().toString();
                    USSDcodes ussdB = new USSDcodes();
                    Intent intent = ussdB.sendUssdCode(getString(R.string.ussdCodeMoneyTransferB)+nomrePaycell.getText().toString() + getString(R.string.ussdCodeSixAznBEnd),getString(R.string.send),getString(R.string.amount),textMessage,getString(R.string.willbesent),
                            nomrePaycell.getText().toString(),getString(R.string.numb),context);
                    startActivity(intent);
                }
                else if(check1aznB.isChecked()){
                    textMessage = check1aznB.getText().toString();
                    USSDcodes ussdC = new USSDcodes();
                    Intent intent = ussdC.sendUssdCode(getString(R.string.ussdCodeMoneyTransferB)+nomrePaycell.getText().toString() + getString(R.string.ussdCodeOneAznBEnd),getString(R.string.send),getString(R.string.amount),textMessage,getString(R.string.willbesent),
                            nomrePaycell.getText().toString(),getString(R.string.numb),context);
                    startActivity(intent);
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
