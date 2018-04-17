package pack.menimcellApp.seymur.azercell2.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.R;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.Gencsim;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.Tarif;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.TarifDoubleK;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.TariffDouble;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.TariffTelebe;
import pack.menimcellApp.seymur.azercell2.fragments.Tariffs.tariffBolge;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Xidmetler.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Xidmetler#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Xidmetler extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public Xidmetler() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Xidmetler.
     */
    // TODO: Rename and change types and number of parameters
    public static Xidmetler newInstance(String param1, String param2) {
        Xidmetler fragment = new Xidmetler();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    Tarif ftarif;
    TariffDouble ftarifdouble;
    ayliqInternet mipAy;
    GundelikMIP mipGun;
    DigerMIP mipDiger;
    TarifDoubleK ftarifdoubleK;
    TariffTelebe ftelebe;
    Gencsim fgencsim;
    tariffBolge fbolge;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ftarif = new Tarif();
        mipAy = new ayliqInternet();
        mipGun = new GundelikMIP();
        mipDiger = new DigerMIP();
        ftarifdouble = new TariffDouble();
        ftarifdoubleK = new TarifDoubleK();
        fgencsim = new Gencsim();
        fbolge = new tariffBolge();
        ftelebe = new TariffTelebe();
    }

//    private ShowNextFragment showNextFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_xidmetler, container, false);
        if (getActivity() != null){
            ((BalanceMenu) getActivity()).hideUpButton();
    }
        view.findViewById(R.id.tarif1).setOnClickListener(this);
        view.findViewById(R.id.tarif2).setOnClickListener(this);
        view.findViewById(R.id.tarif3).setOnClickListener(this);
        view.findViewById(R.id.tarif4).setOnClickListener(this);
        view.findViewById(R.id.tarif5).setOnClickListener(this);
        view.findViewById(R.id.tarif6).setOnClickListener(this);
        view.findViewById(R.id.mipAyAction).setOnClickListener(this);
        view.findViewById(R.id.mipGunAction).setOnClickListener(this);
        view.findViewById(R.id.mipDigerAction).setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    final String TAG = "cyrcle";
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d(TAG, "fXidmetler onDetach");

    }

    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.tarif1) {
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, ftarif);
               t.addToBackStack("e");
               t.commit();
           }

        }

        else if (view.getId() == R.id.tarif2) {
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, ftarifdouble);
               t.addToBackStack("e");
               t.commit();
           }

        } else if (view.getId() == R.id.tarif3){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, fbolge);
               t.addToBackStack("e");
               t.commit();
           }

        }
        else if (view.getId() == R.id.tarif4){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, fgencsim);
               t.addToBackStack("e");
               t.commit();

           }

        }
        else if (view.getId() == R.id.tarif5){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, ftarifdoubleK);
               t.addToBackStack("e");
               t.commit();
           }

       }
        else if (view.getId() == R.id.tarif6){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, ftelebe);
               t.addToBackStack("e");
               t.commit();
           }

        }
       else if (view.getId() == R.id.mipAyAction){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, mipAy);
               t.addToBackStack("e");
               t.commit();
           }

       }
       else if (view.getId() == R.id.mipGunAction){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, mipGun);
               t.addToBackStack("e");
               t.commit();
           }

       }
       else if (view.getId() == R.id.mipDigerAction){
           FragmentTransaction t = null;
           if (this.getFragmentManager() != null) {
               t = this.getFragmentManager().beginTransaction();
               t.replace(R.id.fragment_container, mipDiger);
               t.addToBackStack("e");
               t.commit();
           }

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
