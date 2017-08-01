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

public class MERVAdapter extends RecyclerView.Adapter<MERVAdapter.MEViewHolder> {

    public static int mainEventTitleIndex;
    public  static String mainEventTitle;
    ArrayList<EventsDataModel> dataSet;
    private Context context;
    private int lastpos = 0;

    public static class MEViewHolder extends RecyclerView.ViewHolder {

        TextView event_name;
        ImageView event_image;
        public ScheduleDataModel current;

        public MEViewHolder(View itemView) {
            super(itemView);
            this.event_name = (TextView) itemView.findViewById(R.id.main_event_name);
            this.event_image = (ImageView) itemView.findViewById(R.id.main_event_image);
        }
    }

    public MERVAdapter(ArrayList<EventsDataModel> data, Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MEViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_item,
                parent, false);

        MEViewHolder viewHolder = new MEViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MEViewHolder holder, final int listPosition) {

        holder.event_name.setText(dataSet.get(listPosition).getEvent_name());
        holder.event_image.setImageResource(dataSet.get(listPosition).getEvent_image());

        holder.event_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainEventTitleIndex = listPosition;
                mainEventTitle = dataSet.get(listPosition).getEvent_name();
                Intent i = new Intent(context, SubEvent.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        View v = holder.itemView;
        Animation a=AnimationUtils.loadAnimation(context, R.anim.fade_repeat_events);
        v.startAnimation(a);
        a.setStartOffset(listPosition*100);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
