package phaseshift.com.demophase.Team;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import phaseshift.com.demophase.AboutBMS.AboutBMSActivity;

import phaseshift.com.demophase.AboutPS.AboutPSActivity;
import phaseshift.com.demophase.AboutPS.FirstFragment;
import phaseshift.com.demophase.AboutPS.SecondFragment;
import phaseshift.com.demophase.AboutPS.ThirdFragment;
import phaseshift.com.demophase.Developer.DeveloperActivity;
import phaseshift.com.demophase.Events.EventsActivity;
import phaseshift.com.demophase.Map.MapsActivity;
import phaseshift.com.demophase.R;

import static phaseshift.com.demophase.R.id.viewPager;

public class TeamActivity extends AppCompatActivity
        implements TeamRouter,NavigationView.OnNavigationItemSelectedListener {
    Context context;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
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
        navigationView.setCheckedItem(R.id.Team);

        init();
    }

    public void init()
    {
        viewPager = (ViewPager) findViewById(R.id.viewpager1);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FacultyFragment facultyFragment = new FacultyFragment();
        adapter.addFragment(facultyFragment,"Faculty");

        StudentFragment studentFragment = new StudentFragment();
        adapter.addFragment(studentFragment,"Student");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
//        getMenuInflater().inflate(R.menu.contact, menu);
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
    public void goToDeveloper(Context context) {
        Intent intent=new Intent(context, DeveloperActivity.class);
        startActivity(intent);
    }
}
