package jamshedpur.nit.culfest.com.culfest17;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SERVAdapter extends RecyclerView.Adapter<SERVAdapter.SEViewHolder> {

    public static String subEventTitle;
    ArrayList<EventsDataModel> dataSet;
    private Context context;
    private int lastpos = 0;

    public static class SEViewHolder extends RecyclerView.ViewHolder {

        TextView event_name;
        ImageView event_image;
        public ScheduleDataModel current;

        public SEViewHolder(View itemView) {
            super(itemView);
            this.event_name = (TextView) itemView.findViewById(R.id.main_event_name);
            this.event_image = (ImageView) itemView.findViewById(R.id.main_event_image);
        }
    }

    public SERVAdapter(ArrayList<EventsDataModel> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public SEViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_item,
                parent, false);

        SEViewHolder viewHolder = new SEViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SEViewHolder holder, final int listPosition) {

        try{

            holder.event_name.setText(dataSet.get(listPosition).getEvent_name());
            holder.event_image.setImageResource(dataSet.get(listPosition).getEvent_image());

            holder.event_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subEventTitle = dataSet.get(listPosition).getEvent_name();
                    Intent i = new Intent(context, ChildEvent.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });

            View v = holder.itemView;
            Animation a=AnimationUtils.loadAnimation(context, R.anim.fade_repeat_events);
            v.startAnimation(a);
            a.setStartOffset(listPosition*100);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
