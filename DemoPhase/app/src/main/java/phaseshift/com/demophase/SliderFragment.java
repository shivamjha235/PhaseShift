package phaseshift.com.demophase;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shivam on 17-08-2017.
 */

public class SliderFragment extends android.support.v4.app.Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.slide_fragment, container, false);

        return v;
    }

    public static SliderFragment newInstance() {

        SliderFragment f = new SliderFragment();

        return f;
    }
}