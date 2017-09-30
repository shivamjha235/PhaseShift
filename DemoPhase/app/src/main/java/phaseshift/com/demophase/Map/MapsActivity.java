package phaseshift.com.demophase.Map;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import phaseshift.com.demophase.AboutBMS.AboutBMSActivity;
import phaseshift.com.demophase.AboutPS.AboutPSActivity;
import phaseshift.com.demophase.Developer.DeveloperActivity;
import phaseshift.com.demophase.Team.TeamActivity;
import phaseshift.com.demophase.Events.EventsActivity;
import phaseshift.com.demophase.R;

public class MapsActivity extends AppCompatActivity
        implements MapRouter,NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    Context context;
    GoogleMap map;
    Marker marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context=this;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.Map);

        if(googleServiceAvailable())
        {
            Toast.makeText(this,"Connected",Toast.LENGTH_LONG).show();
            initMap();
        }
    }
    private void initMap()
    {
        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }
    public boolean googleServiceAvailable(){
        GoogleApiAvailability api=GoogleApiAvailability.getInstance();
        int isAvailable=api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS)
            return true;
        else if(api.isUserResolvableError(isAvailable))
        {
            Dialog dialog=api.getErrorDialog(this,isAvailable,0);
            dialog.show();
        }
        else
        {
            Toast.makeText(this,"Cannot connect to play services",Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.maps, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Events) {
            goToEvents(this);
            finish();

        } else if (id == R.id.Team) {
            goToTeam(context);
            finish();
        } else if (id == R.id.Map) {
            goToMaps(context);
            finish();
        }
        else if (id == R.id.AboutBMSCE) {
            goToAboutBMS(context);
            finish();
        }
        else if (id == R.id.AboutPS) {
            goToAboutPS(context);
            finish();
        }else if(id == R.id.Developer){
            goToDeveloper(context);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void goToMaps(Context context) {
        Intent intent=new Intent(context, MapsActivity.class);
        startActivity(intent);

    }

    @Override
    public void goToAboutBMS(Context context) {
        Intent intent=new Intent(context, AboutBMSActivity.class);
        startActivity(intent);

    }

    @Override
    public void goToTeam(Context context) {
        Intent intent=new Intent(context, TeamActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToAboutPS(Context context) {
        Intent intent=new Intent(context, AboutPSActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToEvents(Context context) {
        Intent intent=new Intent(context, EventsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        map=googleMap;
        goToLocationZoom(12.9416079,77.566883,15);
        if(marker != null)
            marker.remove();
        MarkerOptions options=new MarkerOptions().title("BMS College Of Engineering").position(new LatLng(12.9416079,77.566883));
        marker=map.addMarker(options);
    }

    private void goToLocation(double lat, double l)
    {
        LatLng ll=new LatLng(lat,l);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(ll);
        map.moveCamera(cameraUpdate);
    }
    private void goToLocationZoom(double lat, double l,float zoom)
    {
        LatLng ll=new LatLng(lat,l);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        map.moveCamera(cameraUpdate);

    }
    @Override
    public void goToDeveloper(Context context) {
        Intent intent=new Intent(context, DeveloperActivity.class);
        startActivity(intent);
    }
}
