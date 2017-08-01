package jamshedpur.nit.culfest.com.culfest17;


import android.content.Context;
import android.graphics.Color;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Aditya on 26-12-2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    ArrayList<NewsModel> dataset;
    Context context;
    int lastpos=0;

    public  class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView title, time;
        CardView cardView;


        public NewsViewHolder(View itemView) {
            super(itemView);
            this.cardView=(CardView)itemView.findViewById(R.id.schedule_card_view);
            this.title = (TextView) itemView.findViewById(R.id.card_title);
            this.time = (TextView) itemView.findViewById(R.id.card_time);

        }
    }

    public NewsAdapter(ArrayList<NewsModel> data,Context context){this.dataset=data;
        this.context=context;}

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card_layout, parent, false);
        NewsViewHolder newsViewHolder=new NewsViewHolder(view);


        // newsViewHolder.cardView.setCardBackgroundColor(getRandomColor2());
        //title_tv.setTextColor(color[1]);


       // Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide_out_down_splash_icon);
        //cardView.startAnimation(animation);



        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder,final int position) {
        TextView title_tv = holder.title;
        TextView time_tv = holder.time;
        CardView cv=holder.cardView;


        View v = holder.itemView;
        v.startAnimation(AnimationUtils.loadAnimation(context, (position > lastpos) ? R.anim.up_from_bottom : R.anim.down_from_top));
        lastpos = position;

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = AnimatorInflater
                    .loadStateListAnimator(context, R.animator.lift_on_touch);
            cv.setStateListAnimator(stateListAnimator);
        }*/



        //    v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
       // Animation a=AnimationUtils.loadAnimation(context,R.anim.slide_out_down_news_feed);
        //v.startAnimation(a);
        // a.startOffset(position*100);


        // slide_in_left, slide_in_right, slide_in_up, slide_out_down

        title_tv.setText(dataset.get(dataset.size()-1-position).getTitle());
        time_tv.setText(dataset.get(dataset.size()-1-position).getTime());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }



    public int getRandomColor2(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }


    /**
     * view-source:http://www.kareno.org/js/colors/ 参考
     *Get Random background color and the text color for the background
     * @return 0--》background
     *          1--》text color
     */
    public static  int[] getRandomColor() {
        Random random = new Random();
        int RGB = 0xff + 1;
        int[] colors = new int[2];
        int a = 256;
        int r1 = (int) Math.floor(Math.random() * RGB);
        int r2 = (int) Math.floor(Math.random() * RGB);
        int r3 = (int) Math.floor(Math.random() * RGB);
        colors[0] = Color.rgb(r1, r2, r3);
        if((r1 + r2 + r3) > 450) {
            colors[1] = Color.parseColor("#222222");
        }else{
            colors[1] = Color.parseColor("#ffffff");
        }
        return colors;
    }

}
