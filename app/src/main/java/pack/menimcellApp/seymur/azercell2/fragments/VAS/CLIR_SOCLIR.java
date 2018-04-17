package pack.menimcellApp.seymur.azercell2.fragments.VAS;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CLIR_SOCLIR.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CLIR_SOCLIR#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CLIR_SOCLIR extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CLIR_SOCLIR() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CLIR_SOCLIR.
     */
    // TODO: Rename and change types and number of parameters
    public static CLIR_SOCLIR newInstance(String param1, String param2) {
        CLIR_SOCLIR fragment = new CLIR_SOCLIR();
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
    Button OneDaySoclir;
    Button SevenDaySoclir;
    Button MonthDaySoclir;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clir__soclir, container, false);
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }
        OneDaySoclir = (Button)view. findViewById(R.id.SoclirOneD);
        OneDaySoclir.setOnClickListener(this);
        SevenDaySoclir = (Button)view.findViewById(R.id.SoclirSevenD);
        SevenDaySoclir.setOnClickListener(this);
        MonthDaySoclir = (Button)view.findViewById(R.id.SoclirMonth);
        MonthDaySoclir.setOnClickListener(this);
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
    String SoclirSMSOneD = "9001";
    String SoclirSMSSevenD = "9007";
    String SoclirSMSMonthD = "9030";
    String Textmsg;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.SoclirOneD):
                Textmsg = OneDaySoclir.getText().toString();
                sendMessageSMS(SoclirSMSOneD);
                break;
            case(R.id.SoclirSevenD):
                Textmsg = SevenDaySoclir.getText().toString();
                sendMessageSMS(SoclirSMSSevenD);
                break;
            case(R.id.SoclirMonth):
                Textmsg = MonthDaySoclir.getText().toString();
                sendMessageSMS(SoclirSMSMonthD);
                break;
        }
    }
    public void sendMessageSMS(String amount){
        Intent intent = new Intent(getActivity(), SendSMSTariff.class);
        Bundle b = new Bundle();
        b.putString("first", amount);
        b.putString("second"," ");
        b.putString("messageTittle",getString(R.string.youWill) +" "+getString(R.string.subscribeFor)+" "+Textmsg+" " + getString(R.string.ClirStatus));
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
