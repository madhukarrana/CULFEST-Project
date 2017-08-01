package jamshedpur.nit.culfest.com.culfest17;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Aditya on 27-12-2016.
 */

public class Map extends Fragment {


    ImageView v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_map, container, false);
        getActivity().setTitle("Map");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(android.R.drawable.ic_dialog_map);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.maps)));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor((ContextCompat.getColor(getContext() , R.color.maps_status)));
        }

        v=(ImageView)v.findViewById(R.id.imageView);
        TouchImageView img = new TouchImageView(getContext());
        img.setImageResource(R.drawable.nitmap);//image name

        img.setMaxZoom(2f);
        v=img;




        return v;
    }
}
