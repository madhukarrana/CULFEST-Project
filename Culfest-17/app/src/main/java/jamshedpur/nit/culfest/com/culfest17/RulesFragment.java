package jamshedpur.nit.culfest.com.culfest17;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RulesFragment extends Fragment {


    public RulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_rules, container, false);

        TextView t=(TextView)v.findViewById(R.id.rules);
        Typeface face1=Typeface.createFromAsset(getContext().getAssets(),"fonts/PrinsesstartaBoldDEMO.ttf");
        t.setTypeface(face1);

        switch(ChildEvent.actionBarTitle)
        {
            case "RADIANCE":
                t.setText(Html.fromHtml(EventDescription.Rules[31]));
                //setReminder(actionBarTitle,"10-FEB-2017 04:00:00","10-FEB-2017 06:00:00");
                break;
            case "CHOREO NIGHT":
                t.setText(Html.fromHtml(EventDescription.Rules[2]));
                break;
            case "HALLA BOL":
                t.setText(Html.fromHtml(EventDescription.Rules[24]));
                break;
            case "JOURNALISM":
                t.setText(Html.fromHtml(EventDescription.Rules[19]));
                break;
            case "THEME QUIZ":
                t.setText(Html.fromHtml(EventDescription.Rules[35]));
                break;
            case "POSHAK":
                t.setText(Html.fromHtml(EventDescription.Rules[30]));
                break;
            case "DISTORTION":
                t.setText(Html.fromHtml(EventDescription.Rules[11]));
                break;
            case "FOOT LOOSE":
                t.setText(Html.fromHtml(EventDescription.Rules[14]));
                break;
            case "DANCE DUO":
                t.setText(Html.fromHtml(EventDescription.Rules[10]));
                break;
            case "SHAKE ON BEAT":
                t.setText(Html.fromHtml(EventDescription.Rules[32]));
                break;
            case "MONO ACTING":
                t.setText(Html.fromHtml(EventDescription.Rules[22]));
                break;
            case "MERI MAGGI":
                t.setText(Html.fromHtml(EventDescription.Rules[20]));
                break;
            case "RANGMANCH":
                t.setText(Html.fromHtml(EventDescription.Rules[23]));
                break;
            case "MIME":
                t.setText(Html.fromHtml(EventDescription.Rules[21]));
                break;
            case "INDIA QUIZ":
                t.setText(Html.fromHtml(EventDescription.Rules[18]));
                break;
            case "ENTERTAINMENT QUIZ":
                t.setText(Html.fromHtml(EventDescription.Rules[13]));
                break;
            case "JAM":
                t.setText(Html.fromHtml(EventDescription.Rules[5]));
                break;
            case "POTPOURRI":
                t.setText(Html.fromHtml(EventDescription.Rules[26]));
                break;
            case "DEBATE":
                t.setText(Html.fromHtml(EventDescription.Rules[25]));
                break;
            case "WIT-A-STORY":
                t.setText(Html.fromHtml(EventDescription.Rules[7]));
                break;
            case "POETRY SLAM":
                t.setText(Html.fromHtml(EventDescription.Rules[27]));
                break;
            case "CREATIVE WRITING":
                t.setText(Html.fromHtml(EventDescription.Rules[4]));
                break;
            case "SSMQ":

                t.setText(Html.fromHtml(EventDescription.Rules[6]));
                break;
            case "EASTERN VOCALS":
                t.setText(Html.fromHtml(EventDescription.Rules[12]));
                break;
            case "WESTERN VOCALS":
                t.setText(Html.fromHtml(EventDescription.Rules[39]));
                break;
            case "DUET VOCALS":
                t.setText(Html.fromHtml(EventDescription.Rules[17]));
                break;
            case "GROUP SONG":
                t.setText(Html.fromHtml(EventDescription.Rules[16]));
                break;
            case "RANGOLI":
                t.setText(Html.fromHtml(EventDescription.Rules[9]));
                break;
            case "FACE PAINTING":
                t.setText(Html.fromHtml(EventDescription.Rules[8]));
                break;
            case "T-SHIRT PAINTING":
                t.setText(Html.fromHtml(EventDescription.Rules[28]));
                break;
            case "CLAY DOH":
                t.setText(Html.fromHtml(EventDescription.Rules[3]));
                break;
            case "TRIATHLON":
                t.setText(Html.fromHtml(EventDescription.Rules[37]));
                break;
            case "SOAP CARVING":
                t.setText(Html.fromHtml(EventDescription.Rules[29]));

                break;
            case "FUTSAL":
                t.setText(Html.fromHtml(EventDescription.Rules[15]));
                break;
            case "TECHNO CRICKET":
                t.setText(Html.fromHtml(EventDescription.Rules[33]));
                break;
            case "FACE-OFF":
                t.setText(Html.fromHtml(EventDescription.Rules[34]));
                break;
            case "RJ HUNT":

                break;
            case "TREASURE HUNT":
                t.setText(Html.fromHtml(EventDescription.Rules[36]));
                break;
            case "ANTAKSHRI":
                t.setText(Html.fromHtml(EventDescription.Rules[0]));
                break;
            case "UNPLUGGED":
                t.setText(Html.fromHtml(EventDescription.Rules[38]));
                break;
            case "COS PLAY":

                break;
            case "BLIND DATE":
                t.setText(Html.fromHtml(EventDescription.Rules[1]));
                break;
            case "PAPER DANCE":

                break;





        }
        return v;
    }

}
