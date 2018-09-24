package pack.menimcellApp.seymur.azercell2.fragments.BakcellFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;
import pack.menimcellApp.seymur.azercell2.R;

import static pack.menimcellApp.seymur.azercell2.R.color.colorBakcellAccess;
import static pack.menimcellApp.seymur.azercell2.R.color.pinkAcces;
import static pack.menimcellApp.seymur.azercell2.R.color.white;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreditB.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreditB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditB extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CreditB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditB.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditB newInstance(String param1, String param2) {
        CreditB fragment = new CreditB();
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
    private Context context;
    TextView checkDebtsC;
    TextView checkDebtsK;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_credit_b, container, false);
        checkDebtsC = view.findViewById(R.id.checkDebtsCin);
        checkDebtsC.setText(Html.fromHtml(getString(R.string.checkMyDebts)));
        checkDebtsK = view.findViewById(R.id.checkDebtsKlass);
        checkDebtsK.setText(Html.fromHtml(getString(R.string.checkMyDebts)));

        view.findViewById(R.id.CinCreditOneAzn).setOnClickListener(this);
        view.findViewById(R.id.CinCreditwoAznBtn).setOnClickListener(this);
        view.findViewById(R.id.checkDebtsCin).setOnClickListener(this);
        view.findViewById(R.id.klassCreditOneAzn).setOnClickListener(this);
        view.findViewById(R.id.klassCrediFiveAznBtn).setOnClickListener(this);
        view.findViewById(R.id.checkDebtsCin).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        checkDebtsC.setTextColor(getResources().getColor(white));
                        checkDebtsC.setBackgroundColor(getResources().getColor(colorBakcellAccess));
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        checkDebtsC.setTextColor(getResources().getColor(colorBakcellAccess));
                        checkDebtsC.setBackgroundColor(getResources().getColor(white));
                        break;
                    }
                }
                return false;
            }
        });
        view.findViewById(R.id.checkDebtsKlass).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        checkDebtsK.setTextColor(getResources().getColor(white));
                        checkDebtsK.setBackgroundColor(getResources().getColor(colorBakcellAccess));
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        checkDebtsK.setTextColor(getResources().getColor(colorBakcellAccess));
                        checkDebtsK.setBackgroundColor(getResources().getColor(white));
                        break;
                    }
                }
                return false;
            }
        });
        view.findViewById(R.id.checkDebtsCin).setOnClickListener(this);
        view.findViewById(R.id.checkDebtsKlass).setOnClickListener(this);


        return view;
        //REMEMBER 5% fee for ussd in cinCREDIT
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
            case (R.id.CinCreditOneAzn):

                USSDcodes ussdA = new USSDcodes();
                Intent intent = ussdA.sendUssdCode(getString(R.string.ussdCodeOneAzn),getString(R.string.get),getString(R.string.creditOneAzn),getString(R.string.credit),
                        getString(R.string.creditOneAznFee),getString(R.string.fee),context);
                startActivity(intent);
                break;

            case (R.id.CinCreditwoAznBtn):
                USSDcodes ussd = new USSDcodes();
                Intent intentA = ussd.sendUssdCode(getString(R.string.ussdCodeTwoAznCin),getString(R.string.get),getString(R.string.creditTwoAzn),getString(R.string.credit),
                        getString(R.string.creditTwoAznFee),getString(R.string.fee),context);
                startActivity(intentA);
                break;
            case (R.id.klassCreditOneAzn):
                USSDcodes ussdB = new USSDcodes();
                Intent intentB = ussdB.sendUssdCode(getString(R.string.ussdCodeOneAznKlass),getString(R.string.get),getString(R.string.creditOneAzn),getString(R.string.credit),
                        getString(R.string.creditOneAznFee),getString(R.string.fee),context);
                startActivity(intentB);
                break;
            case (R.id.KlassCreditwoAznBtn):
                USSDcodes ussdF = new USSDcodes();
                Intent intentF = ussdF.sendUssdCode(getString(R.string.ussdCodeTwoAznKlass),getString(R.string.get),getString(R.string.creditTwoAzn),getString(R.string.credit),
                        getString(R.string.creditTwoAznFee),getString(R.string.fee),context);
                startActivity(intentF);
                break;
            case (R.id.klassCrediFiveAznBtn):
                USSDcodes ussdC = new USSDcodes();
                Intent intentC = ussdC.sendUssdCode(getString(R.string.ussdCodeFiveAznKlass),getString(R.string.get),getString(R.string.creditFiveAzn),getString(R.string.credit),
                        getString(R.string.crediFiveAznFee),getString(R.string.fee),context);
                startActivity(intentC);
                break;
            case (R.id.checkDebtsCin):
                USSDcodes ussdE = new USSDcodes();
                Intent intentE = ussdE.sendUssdCode(getString(R.string.ussdCodeCheckCinCredit),getString(R.string.checkMyCreditBalance),context);
                startActivity(intentE);
                break;
            case (R.id.checkDebtsKlass):
                USSDcodes ussdD = new USSDcodes();
                Intent intentD = ussdD.sendUssdCode(getString(R.string.ussdCodeCheckKlassCredit),getString(R.string.checkMyCreditBalance),context);
                startActivity(intentD);
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
