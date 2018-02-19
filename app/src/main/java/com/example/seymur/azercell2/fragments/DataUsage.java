package com.example.seymur.azercell2.fragments;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.seymur.azercell2.BalanceMenu;
import com.example.seymur.azercell2.R;

import java.lang.invoke.MethodHandle;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DataUsage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DataUsage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataUsage extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DataUsage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Xercler.
     */
    // TODO: Rename and change types and number of parameters
    public static DataUsage newInstance(String param1, String param2) {
        DataUsage fragment = new DataUsage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    ProgressBar mprogressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    /////-----------------//////
//    int progresBarPercent = Integer.parseInt(getString(R.string.AllProgressNumb));
    int CallsProgressNumb = 54;
    int InternetProgressNumb = 73;
    int CreditsProgressNumb = 21;
    TextView tv;
    TextView ProgressTittle;

    int counter = 0;
    /////-----------------//////
    private Handler mHandler = new Handler();
    private long mStartRX = 0;
    private long mStartTX = 0;
    Integer rxMB = 10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_xercler, container, false);
        view.findViewById(R.id.dataUsage50MB).setOnClickListener(this);
        view.findViewById(R.id.dataUsage500Mb).setOnClickListener(this);
        view.findViewById(R.id.dataUsage1GB).setOnClickListener(this);
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }
        mprogressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tv = (TextView) view.findViewById(R.id.percentage);
        ProgressTittle = (TextView) view.findViewById(R.id.dataUsageTittle);

//        getProgressNumb(Integer.parseInt((String) tv.getText()));
//        getProgressNumb(Integer.parseInt((String) tv.getText()));
        //MBusage
//        mStartRX = TrafficStats.getTotalRxBytes();
        mStartTX = TrafficStats.getTotalTxBytes();

            if (mStartRX == TrafficStats.UNSUPPORTED || mStartTX == TrafficStats.UNSUPPORTED) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("Uh Oh!");
                alert.setMessage("Your device does not support traffic stat monitoring.");
                alert.show();
            } else {
                mHandler.postDelayed(mRunnable, 1000);
//                getProgressNumb(Integer.parseInt((String)tv.getText()));
                mHandler.postDelayed(getmRunnable,1000);
            }
            return view;


    }


    public final Runnable mRunnable = new Runnable() {
        @SuppressLint("SetTextI18n")
        public void run() {
//            TextView RX = (TextView)getView().findViewById(R.id.RX);
//            TextView TX = (TextView)getView().findViewById(R.id.TX);
            long rxBytes = (TrafficStats.getTotalRxBytes()- mStartRX)
                    /100000
                    ;
            rxMB  = (int) rxBytes;
            tv.setText(Integer.toString(rxMB
                    /10
            ));
//            long txBytes = (TrafficStats.getTotalTxBytes()- mStartTX);
//            TX.setText(Long.toString(rxBytes));
            mHandler.postDelayed(mRunnable, 1000);

        }
    };
    private final Runnable getmRunnable = (new Runnable() {

        @Override
        public void run() {
            getProgressNumb(rxMB/10);
            mHandler.postDelayed(getmRunnable,1000);
        }

    });
    public void getProgressNumb(int ProgressNumb){

        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", rxMB/10, ProgressNumb);
        anim.setDuration(800);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
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

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.dataUsage50MB) {
            if(ProgressTittle.getText() != getResources().getString(R.string.fiftyMB)) {
                mprogressBar.setMax(50);
                ProgressTittle.setText(getResources().getString(R.string.fiftyMB));
            }
        }
        else if(view.getId() == R.id.dataUsage500Mb){
            if(ProgressTittle.getText() != getResources().getString(R.string.fivehundredMB)){
                mprogressBar.setMax(500);
                ProgressTittle.setText(getResources().getString(R.string.fivehundredMB));
            }
        }
        else if (view.getId()==R.id.dataUsage1GB){
            if(ProgressTittle.getText() !=  getResources().getString(R.string.OneGB)){
                mprogressBar.setMax(1000);
                ProgressTittle.setText(getResources().getString(R.string.OneGB));
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
//PROGRESS BAR

//    ----------------