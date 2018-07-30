package pack.menimcellApp.seymur.azercell2.fragments.VAS;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CallScreening.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CallScreening#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallScreening extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CallScreening() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallScreening.
     */
    // TODO: Rename and change types and number of parameters
    public static CallScreening newInstance(String param1, String param2) {
        CallScreening fragment = new CallScreening();
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
    Button AddBlackList;
    Button RemoveBlackList;
    TextView checkTheNumbersBL;
    EditText numberToBlackList;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_call_screening, container, false);
   /*     if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }*/
        AddBlackList = (Button) view.findViewById(R.id.AddBL);
        RemoveBlackList = (Button)view.findViewById(R.id.RemoveBL);
        checkTheNumbersBL = (TextView)view.findViewById(R.id.checkTheNumbersBL);
        numberToBlackList = (EditText)view.findViewById(R.id.numberBlackList);
        numberToBlackList.setInputType(InputType.TYPE_CLASS_PHONE);
        AddBlackList.setOnClickListener(this);
        RemoveBlackList.setOnClickListener(this);
        checkTheNumbersBL.setOnClickListener(this);

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
    String numberOfBL = "9313";
    String textOfBl;
    String checkThBlackList  = "list";
    String alertText;
    String PriceOfAddBL = "0.24";
    String PriceOfSMS = "0.01";
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.AddBL):
                if (numberToBlackList.getText().toString().trim().length() == 10 ) {
                    textOfBl = numberToBlackList.getText().toString() ;
                    sendSMS(numberOfBL, textOfBl, getString(R.string.AddThis) +" "+ textOfBl + " " + getString(R.string.numberToBL), PriceOfAddBL);
                }
                else{
                    Toast.makeText(getActivity(), R.string.pleaseEnterFullNumb,Toast.LENGTH_SHORT).show();
                }
                break;
            case(R.id.RemoveBL):
                if (numberToBlackList.getText().toString().trim().length() == 10 ) {
                    textOfBl = numberToBlackList.getText().toString() ;
                    sendSMS(numberOfBL, textOfBl, getString(R.string.removeThis)+" "+ textOfBl +" "+ getString(R.string.numberFromBL), PriceOfSMS);
                }
                else{
                    Toast.makeText(getActivity(), R.string.pleaseEnterFullNumb,Toast.LENGTH_SHORT).show();
                }
                break;
            case(R.id.checkTheNumbersBL):
                alertText = getString(R.string.CheckTheNumberBlackList);
                sendSMS(numberOfBL,checkThBlackList,alertText,PriceOfSMS);
                break;
        }
    }
    //
    public void sendSMS(String numb,String Text, String alertText ,String Price){
        Intent intent = new Intent(getActivity(), SendSMSTariff.class);
        Bundle b = new Bundle();
        b.putString("first", numb);
        b.putString("second",Text);
        b.putString("messageTittle",alertText + ", "+ Price + " " + getString(R.string.azn));
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
