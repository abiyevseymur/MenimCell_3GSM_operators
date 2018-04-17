package pack.menimcellApp.seymur.azercell2.map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.RequestResult;
import com.akexorcist.googledirection.constant.Unit;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Leg;
import com.akexorcist.googledirection.model.Route;
import com.akexorcist.googledirection.util.DirectionConverter;
import pack.menimcellApp.seymur.azercell2.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pack.menimcellApp.seymur.azercell2.R.id.map;


public class MapsActivity extends AppCompatActivity  implements OnMapReadyCallback, View.OnClickListener {

    GoogleMap mMap;
    private LocationManager locationManager;
    Location location;
    private double latitude;
    private double longitude;
    TextView LatLong;
    private static final int REQUEST_LOCAION = 1;
    Button btnDistance;
    int dist;
    String valueDist;
    String keyDist;
    final String TAG = "myLog";
    Marker marker;
    Double nearbyOfficeLat;
    Double nearbyOffivceLong;
    HashMap<Double, Double> valueOfOficceName;
    Collection<Double> valueOfOficceNameFix;
    //latitude of offices
    double[] ListLat  = {40.3835595, 40.3764934, 40.384283, 40.3715289};
    //longtitude of offices
    double[] ListLong = {49.8241838, 49.8478365, 49.9537396, 49.8384542};
    String[] nameOfOffice = {"Mushteri Xidmetleri","28May","Xatai","Torqoviy"};
    //put them to LIST
    List<double[]> values = new ArrayList<double[]>();
    List<String[]> valueNameOffice = new ArrayList<String[]>();
    NestedHashMap2<String,Double,Double> threeValuesHashmap = new NestedHashMap2<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //Action Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.MainMenu);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCAION);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager != null) {
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                buildAlertMessageNoGps();
            }else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                getLocation();
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
    private void getLocation(){
        if (ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCAION);
        }
        else{
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null){
                latitude =location.getLatitude();
                longitude= location.getLongitude();

            }else{
                Toast.makeText(this,"Unable to Trace your Location",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void buildAlertMessageNoGps(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Html.fromHtml("<font color='#4c2b5e'>Please, Turn On Your GPS connection</font>"))
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        finish();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }


/** calculates the distance between two locations in MILES */

    private double distance(double lat1, double lng1, double lat2, double lng2) {

        double earthRadius = 3958.75;
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;
        int meterConversion = 1609;
        return Double.valueOf(dist * meterConversion).floatValue();
    }

    List<double[]> OfficeLatLng;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }

        values.add(ListLat);
        values.add(ListLong);
        valueNameOffice.add(nameOfOffice);


        LatLng myLoc = new LatLng(1, 1);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLoc));
        for (int i=0; i < ListLat.length;i++){
             marker = mMap.addMarker(new MarkerOptions()
                    // in () - latitude or longtitude only 0 or 1, in [] - order of lat/long
                    .position(new LatLng(values.get(0)[i], values.get(1)[i]))
                    .title(valueNameOffice.get(0)[i]));
        }

//        markerLat = marker.getPosition();
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude))
                .zoom(15)
                .bearing(0)
                .tilt(0)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory
                .newCameraPosition(cameraPosition);
        mMap.moveCamera(cameraUpdate);

        btnDistance = (Button) findViewById(R.id.btnDistance);
        btnDistance.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        LatLong = (TextView) findViewById(R.id.LatLong);
        if (ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCAION);
        }
        else {
            checkNearestDistance();
            showNearestOffice();
        }
        LatLong.setText(getString(R.string.theNearestOfficeIs)+" "+keyDist+" "+getString(R.string.distance) +" "+ valueDist + "m ");
    }
    Integer min;
    public void checkNearestDistance(){
        Map<Integer,  String> hmap = new HashMap<>();

        for (int i = 0; i < ListLat.length;i++){
            dist = (int)distance(latitude,longitude,values.get(0)[i], values.get(1)[i]);
            hmap.put(dist,valueNameOffice.get(0)[i]);
        }

        min = Collections.min(hmap.keySet());
        valueDist = String.valueOf(min);
        keyDist = hmap.get(min);
    }


    String duration;
    ArrayList<LatLng> directionPositionList;
    String status;
    String serverKey = "AIzaSyAy0UuApXDEh-B96IDVlPBAiBU4ZDmykvQ";
    public void showNearestOffice(){
        for (int i = 0 ; i <nameOfOffice.length ; i++){
            threeValuesHashmap.put(valueNameOffice.get(0)[i],values.get(0)[i],values.get(1)[i]);
        }
        valueOfOficceName = threeValuesHashmap.get(keyDist);
        //show lat and long of nearet office
        nearbyOfficeLat = Double.parseDouble(String.valueOf(valueOfOficceName.keySet()).replace("[","").replace("]",""));
        nearbyOffivceLong = Double.parseDouble(String.valueOf(valueOfOficceName.values()).replace("[","").replace("]",""));
        //current location
        if (ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCAION);
        }
        else {

            if (location != null){
                latitude =location.getLatitude();
                longitude= location.getLongitude();

            }else{
                Toast.makeText(this,"Unable to show nearest offices",Toast.LENGTH_SHORT).show();
            }
        }
        GoogleDirection.withServerKey(serverKey)
                .from(new LatLng(latitude,longitude))
                .to(new LatLng(nearbyOfficeLat,nearbyOffivceLong))
                .unit(Unit.METRIC)
                .execute(new DirectionCallback() {
                    @Override
                    public void onDirectionSuccess(Direction direction, String rawBody) {
                        status = direction.getStatus();
                        duration = "denied";

                        if(status.equals(RequestResult.OK)) {
                            Route route = direction.getRouteList().get(0);
                            Leg leg = route.getLegList().get(0);

                            directionPositionList = leg.getDirectionPoint();
                            mMap.addPolyline(DirectionConverter.createPolyline(getApplicationContext(), directionPositionList, 5, Color.BLUE));
                            duration = "new string";
                            directionPositionList = leg.getDirectionPoint();

                        }else if(status.equals(RequestResult.NOT_FOUND)) {
                            // Do something
                            Toast.makeText(MapsActivity.this, R.string.CantFindNearestWay, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onDirectionFailure(Throwable t) {


                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"MapActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MapActivity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MapActivity onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MapActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MapActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MapActivity onDestroy");
    }

}