package phaseshift.com.demophase.Team;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import phaseshift.com.demophase.R;

/**
 * Created by Shivam on 15-08-2017.
 */

public class FacultyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.faculty_frag, container, false);

        return v;
    }

    public static FacultyFragment newInstance(String text) {

        FacultyFragment f = new FacultyFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
