package phaseshift.com.demophase.AboutPS;

/**
 * Created by Shivam on 10-08-2017.
 */

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.todddavies.components.progressbar.ProgressWheel;

import phaseshift.com.demophase.R;

/**
 * Created by Rohan on 10-08-2017.
 */

public class FirstFragment extends Fragment {
    private static TextView mCountdownNote;
    private static ProgressWheel mDaysWheel;
    private static TextView mDaysLabel;
    private static ProgressWheel mHoursWheel;
    private static TextView mHoursLabel;
    private static ProgressWheel mMinutesWheel;
    private static TextView mMinutesLabel;
    private static ProgressWheel mSecondsWheel;
    private static TextView mSecondsLabel;

    // Timer setup
    static Time conferenceTime = new Time(Time.getCurrentTimezone());
    static int hour = 10;
    static int minute = 00;
    static int second = 0;
    static int monthDay = 15;
    // month is zero based...7 == August
    static int month = 8;
    static int year;

    // Values displayed by the timer
    private static int mDisplayDays;
    private static int mDisplayHours;
    private static int mDisplayMinutes;
    private static int mDisplaySeconds;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.first_frag, container, false);

        configureViews(view);
        configureConferenceDate();

        return view;
    }

    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);


        return f;
    }
    private static void configureViews(View v)
    {
        conferenceTime.setToNow();
        year = conferenceTime.year;

        mCountdownNote = (TextView)v.findViewById(R.id.activity_countdown_timer_note);
        mDaysWheel = (ProgressWheel)v.findViewById(R.id.activity_countdown_timer_days);
        mHoursWheel = (ProgressWheel)v.findViewById(R.id.activity_countdown_timer_hours);
        mMinutesWheel = (ProgressWheel)v.findViewById(R.id.activity_countdown_timer_minutes);
        mSecondsWheel = (ProgressWheel)v.findViewById(R.id.activity_countdown_timer_seconds);
        mDaysLabel = (TextView)v.findViewById(R.id.activity_countdown_timer_days_text);
        mHoursLabel = (TextView)v.findViewById(R.id.activity_countdown_timer_hours_text);
        mMinutesLabel = (TextView)v.findViewById(R.id.activity_countdown_timer_minutes_text);
        mSecondsLabel = (TextView)v.findViewById(R.id.activity_countdown_timer_seconds_text);
    }

    private static void configureConferenceDate() {
        conferenceTime.set(second, minute, hour, monthDay, month, year);
        conferenceTime.normalize(true);
        long confMillis = conferenceTime.toMillis(true);

        Time nowTime = new Time(Time.getCurrentTimezone());
        nowTime.setToNow();
        nowTime.normalize(true);
        long nowMillis = nowTime.toMillis(true);

        long milliDiff = confMillis - nowMillis;

        new CountDownTimer(milliDiff, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // decompose difference into days, hours, minutes and seconds
                FirstFragment.mDisplayDays = (int) ((millisUntilFinished / 1000) / 86400);
                FirstFragment.mDisplayHours = (int) (((millisUntilFinished / 1000) - (FirstFragment.mDisplayDays * 86400)) / 3600);
                FirstFragment.mDisplayMinutes = (int) (((millisUntilFinished / 1000) - ((FirstFragment.mDisplayDays * 86400) + (FirstFragment.mDisplayHours * 3600))) / 60);
                FirstFragment.mDisplaySeconds = (int) ((millisUntilFinished / 1000) % 60);

                FirstFragment.mDaysWheel.setText(String.valueOf(FirstFragment.mDisplayDays));
                FirstFragment.mDaysWheel.setProgress(FirstFragment.mDisplayDays);

                FirstFragment.mHoursWheel.setText(String.valueOf(FirstFragment.mDisplayHours));
                FirstFragment.mHoursWheel.setProgress(FirstFragment.mDisplayHours * 15);

                FirstFragment.mMinutesWheel.setText(String.valueOf(FirstFragment.mDisplayMinutes));
                FirstFragment.mMinutesWheel.setProgress(FirstFragment.mDisplayMinutes * 6);

                Animation an = new RotateAnimation(0.0f, 90.0f, 250f, 273f);
                an.setFillAfter(true);

                FirstFragment.mSecondsWheel.setText(String.valueOf(FirstFragment.mDisplaySeconds));
                FirstFragment.mSecondsWheel.setProgress(FirstFragment.mDisplaySeconds * 6);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
