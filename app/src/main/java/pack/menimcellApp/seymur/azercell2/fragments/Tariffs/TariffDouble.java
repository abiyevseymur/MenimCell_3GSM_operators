package pack.menimcellApp.seymur.azercell2.fragments.Tariffs;

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
import android.widget.TextView;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.ObjectClasses.USSDcodes;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.SendSMSTariff;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TariffDouble.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TariffDouble#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TariffDouble extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TariffDouble() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TariffDouble.
     */
    // TODO: Rename and change types and number of parameters
    public static TariffDouble newInstance(String param1, String param2) {
        TariffDouble fragment = new TariffDouble();
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
    String numb = "7575";
    String textSMS;

    //
    Button Gencol5;
    Context context;
    Button GencOl8;
    TextView G5price;
    TextView G8price;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_tariff_double, container, false);
//        if (((BalanceMenu)getActivity()) != null) {
//            ((BalanceMenu)getActivity()).showUpButton();
//        }
        //textTarifDes = (TextView) view.findViewById(R.id.tarifDes);
        G5price = (TextView)view.findViewById(R.id.G5tarrifsPrice);
        G8price = (TextView) view.findViewById(R.id.G8tariffsPrice) ;
        context = getContext();
        Gencol5 = (Button) view.findViewById(R.id.btnG5);
        Gencol5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                textSMS = "G5";
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.ThePriceOfSMS)+" " + getString(R.string.smsPrice)+", " +
                        getString(R.string.tariffPriceIs) +" "+ getString(R.string.g5Price) + " "+ getString(R.string.azn ));
                intent.putExtras(b);

                startActivity(intent);*/
                USSDcodes ussdCode = new USSDcodes();
                Intent intentA = ussdCode.sendUssdCode(getString(R.string.g5Tarrif),getString(R.string.azercelimTarifQiymeti),getString(R.string.g5Price),getString(R.string.azn),context);
                startActivity(intentA);
            }
        });
        GencOl8 = (Button) view.findViewById(R.id.btnG8);
        GencOl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent(getActivity(), SendSMSTariff.class);
                Bundle b = new Bundle();
                textSMS = "G8";
                b.putString("first", numb);
                b.putString("second",textSMS);
                b.putString("messageTittle",getString(R.string.ThePriceOfSMS) +" "+ getString(R.string.smsPrice) + ", " +
                        getString(R.string.tariffPriceIs)+" " + getString(R.string.g8Price) +" " + getString(R.string.azn) );
                intent.putExtras(b);

                startActivity(intent);*/
                USSDcodes ussdCode = new USSDcodes();
                Intent intentA = ussdCode.sendUssdCode(getString(R.string.g8Tarrif),getString(R.string.azercelimTarifQiymeti),getString(R.string.g8Price),getString(R.string.azn),context);
                startActivity(intentA);
            }
        });

        return view;
    }
/*    public void UpdateInfo(String name){
        textTarifDes.setText("Welcomen");
            textTarifDes.setVisibility(View.VISIBLE);
    }*/
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
