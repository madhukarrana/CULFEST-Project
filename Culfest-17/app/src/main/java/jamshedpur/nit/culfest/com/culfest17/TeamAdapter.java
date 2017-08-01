package jamshedpur.nit.culfest.com.culfest17;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private ArrayList<TeamDataModel> dataSet;
    Context context;

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

		TextView name, post;
        CardView cardView;
        public TeamViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.card_name);
            this.post = (TextView) itemView.findViewById(R.id.card_post);
            this.cardView=(CardView)itemView.findViewById(R.id.team_card_view);
        }
    }

    public TeamAdapter(ArrayList<TeamDataModel> data,Context context) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_card_layout, parent, false);
    //    view.setOnClickListener(MainActivity.myOnClickListener);

        TeamViewHolder viewHolder = new TeamViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final TeamViewHolder holder, final int listPosition) {

        TextView name_tv = holder.name;
		TextView post_tv = holder.post;
        View v = holder.itemView;

        name_tv.setText(dataSet.get(listPosition).getName());
		post_tv.setText(dataSet.get(listPosition).getPost());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
