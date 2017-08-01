package jamshedpur.nit.culfest.com.culfest17;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Aditya on 27-12-2016.
 */

public class Developers extends Fragment implements View.OnClickListener{

    Toolbar toolbar;
    int[] imageViews = {R.id.photo_adi, R.id.photo_rk, R.id.photo_ss, R.id.photo_vs, R.id.photo_hs,
            R.id.photo_vk, R.id.photo_mr};
    int[] textViews = {R.id.tvt1, R.id.tvt4, R.id.tvt7, R.id.tvta, R.id.tvtd, R.id.tvtg, R.id.tvtx};
    int[] images = {R.drawable.adi1, R.drawable.roushan, R.drawable.shivam , R.drawable.vishnu,
            R.drawable.himanshu, R.drawable.vivek, R.drawable.madhukar};

    String[] mob = {"7870517024", "9155956813", "9470918557", "8235335705", "8126769400", "8102084620",
            "9955177725"};
    int[] mobTv = {R.id.ph1, R.id.ph2, R.id.ph3, R.id.ph4, R.id.ph5, R.id.ph6, R.id.ph7};
    TextView p1, p2, p3, p4, p5, p6, p7;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_developers, container, false);
        getActivity().setTitle("Developers");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.mipmap.developer_white);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.developers)));


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(getContext() , R.color.developers_status)));
        }

        p1 = (TextView) v.findViewById(mobTv[0]);
        p1.setText("Mob : " + mob[0]);
        p1.setPaintFlags(p1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p1.setOnClickListener(this);
        p2 = (TextView) v.findViewById(mobTv[1]);
        p2.setText("Mob : " + mob[1]);
        p2.setPaintFlags(p2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p2.setOnClickListener(this);
        p3 = (TextView) v.findViewById(mobTv[2]);
        p3.setText("Mob : " + mob[2]);
        p3.setPaintFlags(p3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p3.setOnClickListener(this);
        p4 = (TextView) v.findViewById(mobTv[3]);
        p4.setText("Mob : " + mob[3]);
        p4.setPaintFlags(p4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p4.setOnClickListener(this);
        p5 = (TextView) v.findViewById(mobTv[4]);
        p5.setText("Mob : " + mob[4]);
        p5.setPaintFlags(p5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p5.setOnClickListener(this);
        p6 = (TextView) v.findViewById(mobTv[5]);
        p6.setText("Mob : " + mob[5]);
        p6.setPaintFlags(p6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p6.setOnClickListener(this);
        p7 = (TextView) v.findViewById(mobTv[6]);
        p7.setText("Mob : " + mob[6]);
        p7.setPaintFlags(p7.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        p7.setOnClickListener(this);

        int i = 1;
        RoundedBitmapDrawable circularImage;
        for(int imageviewId : imageViews) {

            ImageView imageView = (ImageView) v.findViewById(imageviewId);
            circularImage = makeCircularImage(images[i-1]);
            imageView.setImageDrawable(circularImage);

            Animation imageanimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right_dev);
            imageanimation.setStartOffset(i*200);
            imageView.startAnimation(imageanimation);

            int textviewId = textViews[i-1];
            TextView textView = (TextView) v.findViewById(textviewId);
            Animation textanimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_dev);
            textView.startAnimation(textanimation);
            textanimation.setStartOffset(i*400 + 1400);

            i++;
        }


        return v;
    }

    private RoundedBitmapDrawable makeCircularImage(int drawable) {

        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), drawable);
        RoundedBitmapDrawable circularImageLocal = RoundedBitmapDrawableFactory.create(getResources(),
                imageBitmap);

        circularImageLocal.setCornerRadius(100);
        circularImageLocal.setCircular(true);
        return circularImageLocal;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.ph1:
                callPhoneIntent(mob[0]);
                break;
            case R.id.ph2:
                callPhoneIntent(mob[1]);
                break;
            case R.id.ph3:
                callPhoneIntent(mob[2]);
                break;
            case R.id.ph4:
                callPhoneIntent(mob[3]);
                break;
            case R.id.ph5:
                callPhoneIntent(mob[4]);
                break;
            case R.id.ph6:
                callPhoneIntent(mob[5]);
                break;
            case R.id.ph7:
                callPhoneIntent(mob[6]);
                break;
        }
    }

    public void callPhoneIntent(String number) {
        number = number.trim();
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("CALL_INTENT", "CALL FAILED", e);
        }
    }
}
