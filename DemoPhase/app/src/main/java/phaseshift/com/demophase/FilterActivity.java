package phaseshift.com.demophase;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import phaseshift.com.demophase.Events.EventsActivity;
import phaseshift.com.demophase.Events.Interactor.Manager;
import phaseshift.com.demophase.Events.Model.Data;
import phaseshift.com.demophase.FilteredEvents.FilteredEvents;

public class FilterActivity extends AppCompatActivity {
    Context context;
    Data[] selectedData1;
    public static Manager manager;
    String cat;
    String day;
    String dept;
    ArrayList<Data> dataDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_filter);

//        final CompoundButton category=(CompoundButton) findViewById(R.id.Category);
        final Button apply = (Button) findViewById(R.id.applyBtn);

        final CheckBox cb_events = (CheckBox) findViewById(R.id.CB_events);
        final CheckBox cb_workshop = (CheckBox) findViewById(R.id.CB_workshops);
        final CheckBox cb_day1 = (CheckBox) findViewById(R.id.CB_day1);
        final CheckBox cb_day2 = (CheckBox) findViewById(R.id.CB_day2);

        final CheckBox cb_arch=(CheckBox)findViewById(R.id.CB_arch);
        final CheckBox cb_biotech=(CheckBox)findViewById(R.id.CB_biotech);
        final CheckBox cb_chemEgg=(CheckBox)findViewById(R.id.CB_chemEgg);
        final CheckBox cb_chem=(CheckBox)findViewById(R.id.CB_chem);
        final CheckBox cb_civil=(CheckBox)findViewById(R.id.CB_civil);
        final CheckBox cb_comApp=(CheckBox)findViewById(R.id.CB_compApp);
        final CheckBox cb_compEgg=(CheckBox)findViewById(R.id.CB_compEgg);
        final CheckBox cb_eee=(CheckBox)findViewById(R.id.CB_eee);
        final CheckBox cb_ece=(CheckBox)findViewById(R.id.CB_ece);
        final CheckBox cb_iem=(CheckBox)findViewById(R.id.CB_iem);
        final CheckBox cb_ise=(CheckBox)findViewById(R.id.CB_ise);
        final CheckBox cb_eie=(CheckBox)findViewById(R.id.CB_eie);
        final CheckBox cb_math=(CheckBox)findViewById(R.id.CB_math);
        final CheckBox cb_mech=(CheckBox)findViewById(R.id.CB_mech);
        final CheckBox cb_me=(CheckBox)findViewById(R.id.CB_me);
        final CheckBox cb_phys=(CheckBox)findViewById(R.id.CB_phys);
        final CheckBox cb_tce=(CheckBox)findViewById(R.id.CB_tce);
        final CheckBox cb_mba=(CheckBox)findViewById(R.id.CB_MBA);


        final boolean[] flag = {false};
        cb_events.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && cb_workshop.isChecked() == true) {
                    cb_workshop.setChecked(false);
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == true && cb_workshop.isChecked() == false) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_workshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && cb_events.isChecked() == true) {
                    cb_events.setChecked(false);
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == true && cb_events.isChecked() == false) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_day1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && cb_day2.isChecked() == true) {
                    cb_day2.setChecked(false);
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == true && cb_day2.isChecked() == false) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_day2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && cb_day1.isChecked() == true) {
                    cb_day1.setChecked(false);
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == true && cb_day1.isChecked() == false) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()|| cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });



        cb_arch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked()|| cb_mba.isChecked()|| cb_tce.isChecked()))
                {
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_biotech.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_chemEgg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_chem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_civil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_comApp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()||
                        cb_compEgg.isChecked()|| cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_compEgg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_eee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_ece.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);
                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_iem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);
                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_ise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()|| cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_eie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()|| cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_math.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()|| cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_mech.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_phys.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_tce.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_tce.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_tce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_mba.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_mba.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        cb_mba.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true && (cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked()))
                {
                    cb_arch.setChecked(false);
                    cb_biotech.setChecked(false);
                    cb_chemEgg.setChecked(false);
                    cb_chem.setChecked(false);
                    cb_civil.setChecked(false);
                    cb_comApp.setChecked(false);
                    cb_compEgg.setChecked(false);
                    cb_eee.setChecked(false);
                    cb_ece.setChecked(false);
                    cb_iem.setChecked(false);
                    cb_ise.setChecked(false);
                    cb_eie.setChecked(false);
                    cb_math.setChecked(false);
                    cb_mech.setChecked(false);
                    cb_me.setChecked(false);
                    cb_phys.setChecked(false);
                    cb_tce.setChecked(false);

                    apply.setVisibility(View.VISIBLE);
                }
                else if (isChecked == true) {
                    apply.setVisibility(View.VISIBLE);
                }
                if (isChecked == false) {
                    apply.setVisibility(View.INVISIBLE);
                }
                if(cb_arch.isChecked() || cb_biotech.isChecked() || cb_chemEgg.isChecked()|| cb_chem.isChecked()||cb_civil.isChecked()|| cb_comApp.isChecked()||
                        cb_compEgg.isChecked()||cb_eee.isChecked()|| cb_ece.isChecked() || cb_iem.isChecked() || cb_ise.isChecked() || cb_eie.isChecked() || cb_math.isChecked()
                        || cb_mech.isChecked() || cb_me.isChecked() || cb_phys.isChecked() || cb_tce.isChecked() || cb_mba.isChecked() || cb_events.isChecked() || cb_workshop.isChecked()
                        || cb_day1.isChecked() || cb_day2.isChecked())
                {
                    apply.setVisibility(View.VISIBLE);
                }
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String a="",b="",c="";

                if(cb_events.isChecked()==true)
                    a="Event";
                if(cb_workshop.isChecked()==true)
                    a="Workshop";
                if(cb_day1.isChecked()==true)
                    b="day1";
                if(cb_day2.isChecked()==true)
                    b="day2";
                if(cb_arch.isChecked()==true)
                    c="arch";
                if(cb_biotech.isChecked()==true)
                    c="biotech";
                if(cb_chemEgg.isChecked()==true)
                    c="chemEgg";
                if(cb_chem.isChecked()==true)
                    c="chem";
                if(cb_civil.isChecked()==true)
                    c="civil";
                if(cb_comApp.isChecked()==true)
                    c="comApp";
                if(cb_compEgg.isChecked()==true)
                    c="compEgg";
                if(cb_eee.isChecked()==true)
                    c="eee";
                if(cb_ece.isChecked()==true)
                    c="ece";
                if(cb_iem.isChecked()==true)
                    c="iem";
                if(cb_ise.isChecked()==true)
                    c="ise";
                if(cb_eie.isChecked()==true)
                    c="eie";
                if(cb_math.isChecked()==true)
                    c="math";
                if(cb_mech.isChecked()==true)
                    c="mech";
                if(cb_phys.isChecked()==true)
                    c="phys";
                if(cb_me.isChecked()==true)
                    c="me";
                if(cb_tce.isChecked()==true)
                    c="tce";
                if(cb_mba.isChecked()==true)
                    c="mba";

                cat = a;
                day = b;
                dept = c;

                filter();

                if(dataDept.size() == 0)
                {
                    Toast.makeText(context,"No Such Event Exists",Toast.LENGTH_SHORT).show();
                }else {
                    EventsActivity.getInstance().finish();
                    Intent intent = new Intent(context, FilteredEvents.class);
                    intent.putParcelableArrayListExtra("data", dataDept);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public void filter()
    {
//        Toast toast = Toast.makeText(EventsActivity.this, day+cat+dept, Toast.LENGTH_LONG);
//        toast.show();
        final ArrayList<Data> dataDay = new ArrayList<Data>();
        selectedData1 = new Data[1];
        manager=Manager.getInstance();

        if(day.equalsIgnoreCase("day1"))
        {
            for(int i = 0;i<manager.DataWrapper.getData().size();i++) {
                if (manager.DataWrapper.getData().get(i).getDay().equalsIgnoreCase("day1"))
                    dataDay.add(manager.DataWrapper.getData().get(i));
            }
        }
        else if(day.equalsIgnoreCase("day2"))
        {
            for(int i = 0;i<manager.DataWrapper.getData().size();i++) {
                if (manager.DataWrapper.getData().get(i).getDay().equalsIgnoreCase("day2"))
                    dataDay.add(manager.DataWrapper.getData().get(i));
            }
        }
        else
        {
            for(int i = 0;i<manager.DataWrapper.getData().size();i++)
            {
                dataDay.add(manager.DataWrapper.getData().get(i));
            }
        }
        ArrayList<Data> dataCat=new ArrayList<Data>();
        if(cat.equalsIgnoreCase("event"))
        {
            for(int i=0;i<dataDay.size();i++)
            {
                if(dataDay.get(i).getCategory().equalsIgnoreCase("Event"))
                    dataCat.add(dataDay.get(i));
            }
        }
        else if(cat.equalsIgnoreCase("workshop"))
        {
            for(int i=0;i<dataDay.size();i++)
            {
                if(dataDay.get(i).getCategory().equalsIgnoreCase("Workshop"))
                    dataCat.add(dataDay.get(i));
            }
        }
        else
        {
            for(int i=0;i<dataDay.size();i++)
            {
                dataCat.add(dataDay.get(i));
            }
        }



        dataDept=new ArrayList<Data>();
        if(dept.equalsIgnoreCase("arch"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Architecture"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("biotech"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Biotechnology"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("ChemEgg"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Chemical Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("chem"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Chemistry"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("civil"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Civil Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("comapp"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("MCA"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("compegg"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Computer Science and Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("eee"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Electronics and Electrical Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("ece"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Electronics and Communication Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("iem"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Industrial Engineering and Management"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("ise"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Information Science and Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("eie"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Electronics and Instrumentation Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("Math"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Mathematics"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("Mech"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Mechanical Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("phys"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Physics"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("Me"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Medical Electronics"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("TCE"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("Telecommunication Engineering"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else if(dept.equalsIgnoreCase("Mba"))
        {
            for(int i=0;i<dataCat.size();i++)
            {
                if(dataCat.get(i).getDepartment().equalsIgnoreCase("MBA"))
                    dataDept.add(dataCat.get(i));
            }
        }
        else
        {
            for(int i=0;i<dataCat.size();i++)
            {
                dataDept.add(dataCat.get(i));
            }
        }
    }
}
