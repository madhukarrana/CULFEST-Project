package jamshedpur.nit.culfest.com.culfest17;


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
public class PrizeFragment extends Fragment {


    public PrizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_prize, container, false);

        TextView t = (TextView) v.findViewById(R.id.total_prize);

        TextView p=(TextView)v.findViewById(R.id.prize_text);

        switch (ChildEvent.actionBarTitle)
        {
            case "RADIANCE":
                t.setText(Html.fromHtml(EventDescription.Prizes[31]));
                //setReminder(actionBarTitle,"10-FEB-2017 04:00:00","10-FEB-2017 06:00:00");
                break;
            case "CHOREO NIGHT":
                t.setText(Html.fromHtml(EventDescription.Prizes[2]));
                break;
            case "HALLA BOL":
                t.setText(Html.fromHtml(EventDescription.Prizes[24]));
                break;
            case "JOURNALISM":
                t.setText(Html.fromHtml(EventDescription.Prizes[19]));
                break;
            case "THEME QUIZ":
                t.setText(Html.fromHtml(EventDescription.Prizes[35]));
                break;
            case "POSHAK":
                t.setText(Html.fromHtml(EventDescription.Prizes[30]));
                break;
            case "DISTORTION":
                t.setText(Html.fromHtml(EventDescription.Prizes[11]));
                break;
            case "FOOT LOOSE":
                t.setText(Html.fromHtml(EventDescription.Prizes[14]));
                break;
            case "DANCE DUO":
                t.setText(Html.fromHtml(EventDescription.Prizes[10]));
                break;
            case "SHAKE ON BEAT":
                t.setText(Html.fromHtml(EventDescription.Prizes[32]));
                break;
            case "MONO ACTING":
                t.setText(Html.fromHtml(EventDescription.Prizes[22]));
                break;
            case "MERI MAGGI":
                t.setText(Html.fromHtml(EventDescription.Prizes[20]));
                break;
            case "RANGMANCH":
                t.setText(Html.fromHtml(EventDescription.Prizes[23]));
                break;
            case "MIME":
                t.setText(Html.fromHtml(EventDescription.Prizes[21]));
                break;
            case "INDIA QUIZ":
                t.setText(Html.fromHtml(EventDescription.Prizes[18]));
                break;
            case "ENTERTAINMENT QUIZ":
                t.setText(Html.fromHtml(EventDescription.Prizes[13]));
                break;
            case "JAM":
                t.setText(Html.fromHtml(EventDescription.Prizes[5]));
                break;
            case "POTPOURRI":
                t.setText(Html.fromHtml(EventDescription.Prizes[26]));
                break;
            case "DEBATE":
                t.setText(Html.fromHtml(EventDescription.Prizes[25]));
                break;
            case "WIT-A-STORY":
                t.setText(Html.fromHtml(EventDescription.Prizes[7]));
                break;
            case "POETRY SLAM":
                t.setText(Html.fromHtml(EventDescription.Prizes[27]));
                break;
            case "CREATIVE WRITING":
                t.setText(Html.fromHtml(EventDescription.Prizes[4]));
                break;
            case "SSMQ":

                t.setText(Html.fromHtml(EventDescription.Prizes[6]));
                break;
            case "EASTERN VOCALS":
                t.setText(Html.fromHtml(EventDescription.Prizes[12]));
                break;
            case "WESTERN VOCALS":
                t.setText(Html.fromHtml(EventDescription.Prizes[39]));
                break;
            case "DUET VOCALS":
                t.setText(Html.fromHtml(EventDescription.Prizes[17]));
                break;
            case "GROUP SONG":
                t.setText(Html.fromHtml(EventDescription.Prizes[16]));
                break;
            case "RANGOLI":
                t.setText(Html.fromHtml(EventDescription.Prizes[9]));
                break;
            case "FACE PAINTING":
                t.setText(Html.fromHtml(EventDescription.Prizes[8]));
                break;
            case "T-SHIRT PAINTING":
                t.setText(Html.fromHtml(EventDescription.Prizes[28]));
                break;
            case "CLAY DOH":
                t.setText(Html.fromHtml(EventDescription.Prizes[3]));
                break;
            case "TRIATHLON":
                t.setText(Html.fromHtml(EventDescription.Prizes[37]));
                break;
            case "SOAP CARVING":
                t.setText(Html.fromHtml(EventDescription.Prizes[29]));
                break;
            case "FUTSAL":
                t.setText(Html.fromHtml(EventDescription.Prizes[15]));
                break;
            case "TECHNO CRICKET":
                t.setText(Html.fromHtml(EventDescription.Prizes[33]));
                break;
            case "FACE-OFF":
                t.setText(Html.fromHtml(EventDescription.Prizes[34]));
                break;
            case "RJ HUNT":

                p.setText("Will be updated soon...");
                break;
            case "TREASURE HUNT":
                t.setText(Html.fromHtml(EventDescription.Prizes[36]));
               // p.setText("Prize Money will be declared at the time of the event");
                break;
            case "ANTAKSHRI":
                t.setText(Html.fromHtml(EventDescription.Prizes[0]));
                break;
            case "UNPLUGGED":
                t.setText(Html.fromHtml(EventDescription.Prizes[38]));
                break;
            case "COS PLAY":

                p.setText("Will be updated soon...");
                break;
            case "BLIND DATE":
                t.setText(Html.fromHtml(EventDescription.Prizes[1]));
                p.setText("Will be updated soon...");
                break;
            case "PAPER DANCE":
                p.setText("Will be updated soon...");
                break;


        }
        return v;  }

}
