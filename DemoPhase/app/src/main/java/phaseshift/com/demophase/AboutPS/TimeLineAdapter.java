package phaseshift.com.demophase.AboutPS;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import phaseshift.com.demophase.AboutPS.model.TimeLineModel;
import phaseshift.com.demophase.R;


/**
 * Created by Rohan on 15-08-2017.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TimeLineModel> mFeedList;

    public TimeLineAdapter(List<TimeLineModel> mFeedList) {
        this.mFeedList = mFeedList;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        mLayoutInflater = LayoutInflater.from(context);
        View view;

        view = mLayoutInflater.inflate(R.layout.item_timeline, parent, false);

        return new TimeLineViewHolder(view, viewType);
    }
    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        TimeLineModel data = mFeedList.get(position);
        holder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker), ContextCompat.getColor(context, R.color.color_primary_dark));

        holder.tYear.setText(data.getYear());
        holder.timelineTitle.setText(data.getTitle());
        holder.timelineBody.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }
}
