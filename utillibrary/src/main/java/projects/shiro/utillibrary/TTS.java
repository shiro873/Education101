package projects.shiro.utillibrary;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TTS {
    TextToSpeech tts;
    Activity activity;
    PreferenceActivity settings;
    private static TTS INSTANCE = null;

    private TTS(Activity activity){
        this.activity = activity;
        final Locale locale = ConfigurationCompat.getLocales(activity.getResources().getConfiguration()).get(0);
        tts = new TextToSpeech(activity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(locale);
            }
        });
    }

    public static synchronized TTS newInstance(Activity activity){
        if(INSTANCE == null){
            INSTANCE = new TTS(activity);
        }
        return INSTANCE;
    }
    /*settings*/
    public void setLocaleFromSettings(Locale locale){
        tts.setLanguage(locale);
    }


    /*end setting*/
    public void Speak(String msg){
        tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null, "TTS_ID");
    }

    public void SaveAsAudio(String msg){
        String state = Environment.getExternalStorageState();
        boolean mExternalStorageWriteable = false;
        boolean mExternalStorageAvailable = false;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // Can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = true;

        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // Can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Can't read or write
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/download");
        dir.mkdirs();
        SimpleDateFormat dateTime = new SimpleDateFormat("dd:MM:yyyy hh:mm:ss");
        Date date = new Date();
        String fileName = dateTime.format(date);
        File file = new File(dir, fileName+".mp3");
        int test = tts.synthesizeToFile((CharSequence) msg, null, file,
                "tts");
    }
}
