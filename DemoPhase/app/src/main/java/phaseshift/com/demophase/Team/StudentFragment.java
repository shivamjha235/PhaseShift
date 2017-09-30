package phaseshift.com.demophase.Team;

/**
 * Created by Shivam on 15-08-2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phaseshift.com.demophase.R;

/**
 * Created by Shivam on 15-08-2017.
 */

public class StudentFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.student_frag, container, false);

        return v;
    }

    public static StudentFragment newInstance(String text) {

        StudentFragment f = new StudentFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
