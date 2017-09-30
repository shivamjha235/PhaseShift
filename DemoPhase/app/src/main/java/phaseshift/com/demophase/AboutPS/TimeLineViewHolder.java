package phaseshift.com.demophase.AboutPS;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;

import butterknife.BindView;
import butterknife.ButterKnife;
import phaseshift.com.demophase.R;

/**
 * Created by Rohan on 15-08-2017.
 */

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_timeline_year)
    TextView tYear;
    @BindView(R.id.text_timeline_title)
    TextView timelineTitle;
    @BindView(R.id.text_timeline_body)
    TextView timelineBody;
    @BindView(R.id.timeline_img)
    ImageView timelineImg;
    @BindView(R.id.time_marker)
    TimelineView mTimelineView;

    public TimeLineViewHolder(View itemView,int viewType) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mTimelineView.initLine(viewType);
    }
}
