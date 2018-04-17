package pack.menimcellApp.seymur.azercell2.fragments;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import pack.menimcellApp.seymur.azercell2.BalanceMenu;
import pack.menimcellApp.seymur.azercell2.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DataUsage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DataUsage#newInstance} factory method to
 * create an instance of this fragment.
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
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
    boolean isWifiConn;
    boolean isMobileConn;
    ImageButton fbButton;
    ImageButton InstaButton;
    EditText editTextInput;
    TextView textViewOutput;
    TextView enterPckg;
    ImageButton dataUsageDone;
    ImageButton dataUsageEdit;
    private Context context ;
    Integer rxMB=10;
    Double RXmbD ;
    long mobilenetworkbyte;
    private static final String DEBUG_TAG = "NetworkStatusExample";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_xercler, container, false);
        enterPckg =  (TextView)view.findViewById(R.id.enterPackage);
        fbButton = (ImageButton)view.findViewById(R.id.fbButton);
        fbButton.setOnClickListener(this);
        InstaButton = (ImageButton)view.findViewById(R.id.instaButton);
        InstaButton.setOnClickListener(this);
        textViewOutput = (TextView)view.findViewById(R.id.textViewOutput);
        editTextInput = (EditText)view.findViewById(R.id.edittextInput);
        dataUsageDone = (ImageButton)view.findViewById(R.id.DataUsageDone);
        dataUsageDone.setOnClickListener(this);
        dataUsageEdit = (ImageButton)view.findViewById(R.id.DataUsageEdit);
        dataUsageEdit.setOnClickListener(this);
        view.findViewById(R.id.textViewOutput);
        if (((BalanceMenu)getActivity()) != null) {
            ((BalanceMenu)getActivity()).showUpButton();
        }
        mprogressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tv = (TextView) view.findViewById(R.id.percentage);
//        ProgressTittle = (TextView) view.findViewById(R.id.Data/**/);
        context = getContext();
//        getProgressNumb(Integer.parseInt((String) tv.getText()));
//        getProgressNumb(Integer.parseInt((String) tv.getText()));
        //MBusage


//            mStartRX = TrafficStats.getTotalRxBytes();
            mobilenetworkbyte = TrafficStats.getMobileRxBytes();
//        mStartTX = TrafficStats.getTotalTxBytes();

            if (mStartRX == TrafficStats.UNSUPPORTED || mStartTX == TrafficStats.UNSUPPORTED) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("Uh Oh!");
                alert.setMessage("Your device does not support traffic stat monitoring.");
                alert.show();
            } else  {

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

                long rxBytes = (TrafficStats.getMobileRxBytes() - mobilenetworkbyte)
                    /100000
                        ;
                rxMB = (int) rxBytes;
                RXmbD = Double.valueOf(rxMB);
                tv.setText(Double.toString(RXmbD
                        / 10
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.DataUsageDone) {
            if(!Objects.equals(editTextInput.getText().toString(), ""))
            textViewOutput.setText(editTextInput.getText().toString());
            editTextInput.setVisibility(View.GONE);
            textViewOutput.setVisibility(View.VISIBLE);
            dataUsageDone.setVisibility(View.GONE);
            dataUsageEdit.setVisibility(View.VISIBLE);
            enterPckg.setText(R.string.yourPackageIsNow);

                mprogressBar.setMax(Integer.parseInt(textViewOutput.getText().toString()));

        }
        if (v.getId() == R.id.DataUsageEdit) {
            if(!Objects.equals(editTextInput.getText().toString(), ""))
            editTextInput.setVisibility(View.VISIBLE);
            textViewOutput.setVisibility(View.GONE);
            dataUsageDone.setVisibility(View.VISIBLE);
            dataUsageEdit.setVisibility(View.GONE);
            enterPckg.setText(R.string.yourPackageIs);
        }
        if (v.getId() == R.id.fbButton) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://bit.ly/2G5Xana"));
            Objects.requireNonNull(getActivity()).startActivity(i);
        }
        if (v.getId() == R.id.instaButton) {
            Toast.makeText(context, R.string.notReady,Toast.LENGTH_SHORT).show();
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