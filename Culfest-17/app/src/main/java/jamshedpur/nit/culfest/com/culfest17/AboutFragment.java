package jamshedpur.nit.culfest.com.culfest17;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_about, container, false);

        TextView t=(TextView)v.findViewById(R.id.description);
        Typeface face1=Typeface.createFromAsset(getContext().getAssets(),"fonts/PrinsesstartaBoldDEMO.ttf");
        t.setTypeface(face1);

        //t.setText(ChildEvent.actionBarTitle);
        switch(ChildEvent.actionBarTitle)
        {
            case "RADIANCE":
                t.setText(Html.fromHtml(EventDescription.Description[43]));
                break;
            case "CHOREO NIGHT":
                t.setText(Html.fromHtml(EventDescription.Description[44]));
                break;
            case "HALLA BOL":
                t.setText(Html.fromHtml(EventDescription.Description[7]));

                break;
            case "JOURNALISM":
                t.setText(Html.fromHtml(EventDescription.Description[27]));

                break;
            case "THEME QUIZ":
                t.setText(Html.fromHtml(EventDescription.Description[30]));

                break;
            case "POSHAK":
                t.setText(Html.fromHtml(EventDescription.Description[18]));

                break;
            case "DISTORTION":
                t.setText(Html.fromHtml(EventDescription.Description[12]));

                break;
            case "FOOT LOOSE":
                t.setText(Html.fromHtml(EventDescription.Description[0]));
                break;
            case "DANCE DUO":
                t.setText(Html.fromHtml(EventDescription.Description[1]));
                break;
            case "SHAKE ON BEAT":
                t.setText(Html.fromHtml(EventDescription.Description[2]));
                break;
            case "MONO ACTING":
                t.setText(Html.fromHtml(EventDescription.Description[3]));

                break;
            case "MERI MAGGI":
                t.setText(Html.fromHtml(EventDescription.Description[4]));
                break;
            case "RANGMANCH":
                t.setText(Html.fromHtml(EventDescription.Description[5]));
                break;
            case "MIME":
                t.setText(Html.fromHtml(EventDescription.Description[6]));

                break;
            case "INDIA QUIZ":
                t.setText(Html.fromHtml(EventDescription.Description[28]));
                break;
            case "ENTERTAINMENT QUIZ":
                t.setText(Html.fromHtml(EventDescription.Description[29]));
                break;
            case "JAM":
                t.setText(Html.fromHtml(EventDescription.Description[19]));

                break;
            case "POTPOURRI":
                t.setText(Html.fromHtml(EventDescription.Description[20]));
                break;
            case "DEBATE":
                t.setText(Html.fromHtml(EventDescription.Description[22]));
                break;
            case "WIT-A-STORY":
                t.setText(Html.fromHtml(EventDescription.Description[23]));
                break;
            case "POETRY SLAM":
                t.setText(Html.fromHtml(EventDescription.Description[24]));
                break;
            case "CREATIVE WRITING":
                t.setText(Html.fromHtml(EventDescription.Description[25]));
                break;
            case "SSMQ":
                t.setText(Html.fromHtml(EventDescription.Description[26]));

                break;
            case "EASTERN VOCALS":
                t.setText(Html.fromHtml(EventDescription.Description[8]));


                break;
            case "WESTERN VOCALS":
                t.setText(Html.fromHtml(EventDescription.Description[9]));

                break;
            case "DUET VOCALS":
                t.setText(Html.fromHtml(EventDescription.Description[10]));

                break;
            case "GROUP SONG":
                t.setText(Html.fromHtml(EventDescription.Description[11]));

                break;
            case "RANGOLI":
                t.setText(Html.fromHtml(EventDescription.Description[13]));

                break;
            case "FACE PAINTING":
                t.setText(Html.fromHtml(EventDescription.Description[14]));

                break;
            case "T-SHIRT PAINTING":
                t.setText(Html.fromHtml(EventDescription.Description[15]));

                break;
            case "CLAY DOH":
                t.setText(Html.fromHtml(EventDescription.Description[16]));

                break;
            case "TRIATHLON":
                t.setText(Html.fromHtml(EventDescription.Description[17]));

                break;
            case "SOAP CARVING":
                t.setText(Html.fromHtml(EventDescription.Description[45]));

                break;
            case "FUTSAL":
                t.setText(Html.fromHtml(EventDescription.Description[31]));
                break;
            case "TECHNO CRICKET":
                t.setText(Html.fromHtml(EventDescription.Description[32]));
                break;
            case "FACE-OFF":
                t.setText(Html.fromHtml(EventDescription.Description[33]));
                break;
            case "RJ HUNT":
                t.setText(Html.fromHtml(EventDescription.Description[34]));
                break;
            case "TREASURE HUNT":
                t.setText(Html.fromHtml(EventDescription.Description[35]));
                break;
            case "ANTAKSHRI":
                t.setText(Html.fromHtml(EventDescription.Description[38]));
                break;
            case "UNPLUGGED":
                t.setText(Html.fromHtml(EventDescription.Description[39]));
                break;
            case "COS PLAY":
                t.setText(Html.fromHtml(EventDescription.Description[40]));
                break;
            case "BLIND DATE":
                t.setText(Html.fromHtml(EventDescription.Description[41]));
                break;
            case "PAPER DANCE":
                t.setText(Html.fromHtml(EventDescription.Description[42]));
                break;





        }




        return v;
    }

}
