package phaseshift.com.demophase.AboutBMS;

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

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import phaseshift.com.demophase.AboutPS.AboutPSActivity;
import phaseshift.com.demophase.Developer.DeveloperActivity;
import phaseshift.com.demophase.Team.TeamActivity;
import phaseshift.com.demophase.DesAnimation;
import phaseshift.com.demophase.Events.EventsActivity;
import phaseshift.com.demophase.Map.MapsActivity;
import phaseshift.com.demophase.R;

public class AboutBMSActivity extends AppCompatActivity
        implements AboutBMSRouter,NavigationView.OnNavigationItemSelectedListener {
    Context context;
    SliderLayout imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bms);
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
        navigationView.setCheckedItem(R.id.AboutBMSCE);

        imageSlider=(SliderLayout)findViewById(R.id.slider);
        imageSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imageSlider.setCustomAnimation(new DesAnimation());
        //imageSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        imageSlider.setDuration(3000);

        DefaultSliderView textSliderView = new DefaultSliderView(this);
        textSliderView.image(R.drawable.bmsce);

        imageSlider.addSlider(textSliderView);

        DefaultSliderView textSliderView2 = new DefaultSliderView(this);
        textSliderView2.image(R.drawable.slider_1);

        imageSlider.addSlider(textSliderView2);

        DefaultSliderView textSliderView3 = new DefaultSliderView(this);
        textSliderView2.image(R.drawable.slider_2);

        imageSlider.addSlider(textSliderView3);


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
//        getMenuInflater().inflate(R.menu.about_bm, menu);
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
