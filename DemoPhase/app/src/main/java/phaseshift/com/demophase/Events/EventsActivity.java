package phaseshift.com.demophase.Events;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import phaseshift.com.demophase.AboutBMS.AboutBMSActivity;
import phaseshift.com.demophase.AboutPS.AboutPSActivity;
import phaseshift.com.demophase.Developer.DeveloperActivity;
import phaseshift.com.demophase.Team.TeamActivity;
import phaseshift.com.demophase.EventDetail.EventDetailActivity;
import phaseshift.com.demophase.Events.Interactor.CallBack;
import phaseshift.com.demophase.Events.Interactor.Manager;
import phaseshift.com.demophase.Events.Model.Data;
import phaseshift.com.demophase.FilterActivity;
import phaseshift.com.demophase.Map.MapsActivity;
import phaseshift.com.demophase.R;
import phaseshift.com.demophase.SplashIntroActivity;
import phaseshift.com.demophase.WorkshopDetail.WorkshopDetailActivity;
import phaseshift.com.demophase.databinding.AppBarEventBinding;


public class EventsActivity extends AppCompatActivity implements EventsRouter,NavigationView.OnNavigationItemSelectedListener {
    public static Manager manager;
    Context context;
    ListView listView;
    ArrayList<Data> data;
    ProgressDialog progressDoalog;
    private AppBarEventBinding binding;
    Data[] selectedData;
    String searchKey1;



    public static final String PREF_KEY_FIRST_START = "com.heinrichreimersoftware.materialintro.demo.PREF_KEY_FIRST_START";
    public static final int REQUEST_CODE_INTRO = 1;

    static EventsActivity e;

    public static EventsActivity getInstance() {
        return e;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDoalog = new ProgressDialog(EventsActivity.this);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("Please Wait...");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        binding = DataBindingUtil.setContentView(this, R.layout.app_bar_event);

        setSupportActionBar(binding.toolbar);

        boolean firstStart = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean(PREF_KEY_FIRST_START, true);

        if (firstStart) {
            Intent intent = new Intent(this, SplashIntroActivity.class);
            startActivityForResult(intent, REQUEST_CODE_INTRO);
        }

        setContentView(R.layout.activity_event);
        context = this;
        manager = Manager.getInstance();
        manager.apiCall();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.Events);
        e = this;

        manager.CallBack(new CallBack() {
            @Override
            public void success() {
                CallMe();
                progressDoalog.dismiss();
            }

            @Override
            public void failed() {
                progressDoalog.dismiss();
                Toast toast = Toast.makeText(EventsActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void noNet() {
                progressDoalog.dismiss();
                Toast toast = Toast.makeText(EventsActivity.this, "No Internet", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


    private void populateListView(ArrayList<Data> data) {
        listView.setAdapter((new CustomAdapter(context,data)));
    }

    private void CallMe()
    {
        selectedData = new Data[1];
        data = manager.DataWrapper.getData();
        listView = (ListView) findViewById(R.id.eventListView);
        populateListView(data);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedData[0] = manager.DataWrapper.getData().get(position);
                if(selectedData[0].getCategory().equalsIgnoreCase("event"))
                    goToEventDetails(context,selectedData[0]);
                else
                    goToWorkshopDetails(context,selectedData[0]);
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INTRO) {
            if (resultCode == RESULT_OK) {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, false)
                        .apply();
            } else {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, true)
                        .apply();
                //User cancelled the intro so we'll finish this activity too.
                finish();
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_reset_first_start) {
//            PreferenceManager.getDefaultSharedPreferences(this).edit()
//                    .putBoolean(PREF_KEY_FIRST_START, true)
//                    .apply();
            Intent intent = new Intent(this, FilterActivity.class);
            startActivity(intent);
            // onPause();
            return true;
        }

        if (item.getItemId() == R.id.reset) {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putBoolean(PREF_KEY_FIRST_START, true)
                    .apply();
//            Intent intent= new Intent(this, FilterActivity.class);
//            startActivity(intent);
            onPause();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    public void goToEventDetails(Context context, Data event) {
        Intent intent = new Intent(context,EventDetailActivity.class);
        intent.putExtra("event",event);
        startActivity(intent);
    }
    public void goToWorkshopDetails(Context context, Data data)
    {
        Intent intent = new Intent(context,WorkshopDetailActivity.class);
        intent.putExtra("event",data);
        startActivity(intent);
    }
    @Override
    public void goToDeveloper(Context context) {
        Intent intent=new Intent(context, DeveloperActivity.class);
        startActivity(intent);
    }
}
