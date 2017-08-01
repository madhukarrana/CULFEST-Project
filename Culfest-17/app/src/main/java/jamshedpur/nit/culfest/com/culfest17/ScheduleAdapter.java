package jamshedpur.nit.culfest.com.culfest17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private ArrayList<ScheduleDataModel> dataSet;
    private int flag;
    private int lastpos;
    Context context;

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

		TextView event, venue, time;
        ImageView img;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            this.img=(ImageView)itemView.findViewById(R.id.img);
            this.event = (TextView) itemView.findViewById(R.id.card_event);
            this.venue = (TextView) itemView.findViewById(R.id.card_venue);
            this.time = (TextView) itemView.findViewById(R.id.card_time);

        }
    }

    public ScheduleAdapter(ArrayList<ScheduleDataModel> data,int flag,Context context) {
        this.dataSet = data; this.flag=flag;this.context=context;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_cards_layout, parent, false);
    //    view.setOnClickListener(MainActivity.myOnClickListener);

        ScheduleViewHolder viewHolder = new ScheduleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, final int listPosition) {

        TextView event_tv = holder.event;
		TextView venue_tv = holder.venue;
		TextView time_tv = holder.time;
        ImageView img=holder.img;
		
        event_tv.setText(dataSet.get(listPosition).getEvent());
		venue_tv.setText(dataSet.get(listPosition).getVenue());
		time_tv.setText(dataSet.get(listPosition).getTime());
        if(flag==1) img.setImageResource(R.drawable.cal10);
        else if(flag==2)img.setImageResource(R.drawable.cal11);
        else if(flag==3)img.setImageResource(R.drawable.cal12);

        View v = holder.itemView;

        //    v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));

        Animation a=AnimationUtils.loadAnimation(context,
                (listPosition > lastpos) ? R.anim.slide_in_left : R.anim.slide_in_right);
        v.startAnimation(a);

        lastpos = listPosition;

        // slide_in_left, slide_in_right, slide_in_up, slide_out_down






    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
