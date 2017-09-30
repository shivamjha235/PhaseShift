package phaseshift.com.demophase.AboutPS;

/**
 * Created by Shivam on 10-08-2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import phaseshift.com.demophase.AboutPS.model.TimeLineModel;
import phaseshift.com.demophase.R;

/**
 * Created by Rohan on 10-08-2017.
 */

public class SecondFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setHasFixedSize(true);

        initView();
        return v;
    }

    private void initView() {
        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(mDataList);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    private void setDataListItems(){
        mDataList.add(new TimeLineModel("2014", "PhaseShift 2014", "BODY 2014",1));
        mDataList.add(new TimeLineModel("2015", "PhaseShift 2015", "BODY 2014",2));
        mDataList.add(new TimeLineModel("2016", "PhaseShift 2016", "BODY 2014",3));
        mDataList.add(new TimeLineModel("2017", "PhaseShift 2017", "BODY 2014",4));
    }

    public static SecondFragment newInstance(String text) {

        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}