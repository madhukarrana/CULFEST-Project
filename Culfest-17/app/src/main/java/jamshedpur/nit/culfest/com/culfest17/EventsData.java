package jamshedpur.nit.culfest.com.culfest17;

import android.provider.VoicemailContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventsData {

    public static String[] mainEventName = {"MEGA EVENTS", "DANCE", "DRAMATICS", "QUIZZING", "LITERARY", "VOCALS",
            "FINE ARTS", "INFORMALS"};
    public static int[] mainEventImage = {R.drawable.fashion, R.drawable.themedance, R.drawable.mime,
            R.drawable.entertainment, R.drawable.journnalism, R.drawable.eastern, R.drawable.clay2, R.drawable.techno2};

    public static String[] megaEvents = {"RADIANCE", "CHOREO NIGHT", "HALLA BOL", "JOURNALISM", "THEME QUIZ", "POSHAK", "DISTORTION"};
    public static int[] megaEventImage = {R.drawable.fashion, R.drawable.choreonite, R.drawable.halla_bol, R.drawable.journnalism, R.drawable.theme, R.drawable.poshak, R.drawable.distortion};

    public static String[] dance = {"FOOT LOOSE", "DANCE DUO", "SHAKE ON BEAT"};
    public static int[] danceImage = {R.drawable.footloose, R.drawable.danceduo, R.drawable.shakeonbeat};

    public static String[] dramatics = {"MONO ACTING", "MERI MAGGI", "RANGMANCH", "MIME", "HALLA BOL"};
    public static int[] dramaticsImage = {R.drawable.monoacting, R.drawable.instkichdi, R.drawable.rangmanc, R.drawable.mime, R.drawable.halla_bol};

    public static String[] quizzing = {"INDIA QUIZ", "ENTERTAINMENT QUIZ", "THEME QUIZ"};
    public static int[] quizzingImage = {R.drawable.india2, R.drawable.entertainment, R.drawable.theme};

    public static String[] vocals = {"EASTERN VOCALS", "WESTERN VOCALS", "DUET VOCALS", "GROUP SONG", "DISTORTION","UNPLUGGED"};
    public static int[] vocalsImage = {R.drawable.eastern, R.drawable.western, R.drawable.duet_song, R.drawable.groupsong, R.drawable.distortion, R.drawable.unplugged};


    public static String[] fine_arts = {"RANGOLI", "FACE PAINTING", "T-SHIRT PAINTING", "CLAY DOH", "TRIATHLON", "POSHAK", "SOAP CARVING"};
    public static int[] fineArtsImage = {R.drawable.rangoli2, R.drawable.face2, R.drawable.tshirt, R.drawable.clay2, R.drawable.traithlon2, R.drawable.poshak, R.drawable.soap_carving};

    public static String[] informals = {"FUTSAL", "TECHNO CRICKET", "FACE-OFF", "RJ HUNT", "TREASURE HUNT", "ANTAKSHRI",  "COS PLAY", "BLIND DATE", "PAPER DANCE"};
    public static int[] informalsImage = {R.drawable.futsal, R.drawable.techno2, R.drawable.faceoff, R.drawable.rj2, R.drawable.treasure2, R.drawable.antakshari2, R.drawable.cos_play, R.drawable.blind_date, R.drawable.paper_dance};

    public static String[] literary = {"JAM", "POTPOURRI", "DEBATE", "WIT-A-STORY", "POETRY SLAM", "CREATIVE WRITING", "SSMQ", "JOURNALISM"};
    public static int[] literaryImage = {R.drawable.jam2, R.drawable.hindi_potpuri2, R.drawable.debate2, R.drawable.wit_a_story2, R.drawable.poetry, R.drawable.creative_writing2, R.drawable.ssmq,R.drawable.journalism2};
}
