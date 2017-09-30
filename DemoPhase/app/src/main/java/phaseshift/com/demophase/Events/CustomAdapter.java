package phaseshift.com.demophase.Events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import phaseshift.com.demophase.Events.Model.Data;
import phaseshift.com.demophase.R;

/**
 * Created by Rohan on 28-07-2017.
 */

public class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<Data> events;

    public CustomAdapter(Context context,ArrayList<Data> events){
        this.context = context;
        this.events = events;
    }
    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        Data event = (Data) getItem(position);

        if(convertView == null)
        {
            holder = new Holder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_list,null);

            holder.imageView = (ImageView)convertView.findViewById(R.id.icon);
            holder.header = (TextView)convertView.findViewById(R.id.header);
            holder.subText = (TextView)convertView.findViewById(R.id.sub_head);

            convertView.setTag(holder);
        }else{
            holder = (Holder)convertView.getTag();
        }

        holder.header.setText(event.getName_of_event());
        holder.subText.setText(event.getDepartment());
        return convertView;
    }

    private class Holder{
        ImageView imageView;
        TextView header;
        TextView subText;
    }
}
