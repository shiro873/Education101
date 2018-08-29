package projects.shiro.utillibrary;

import android.speech.tts.TextToSpeech;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

public class TTS {
    TextToSpeech tts;
    AppCompatActivity activity;

    public TTS(AppCompatActivity activity){
        this.activity = activity;
        final Locale locale = ConfigurationCompat.getLocales(activity.getResources().getConfiguration()).get(0);
        tts = new TextToSpeech(activity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(locale);
            }
        });
    }

    public void Speak(String msg){
        tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null, "TTS_ID");
    }

    public void setLanguage(Locale locale){
        tts.setLanguage(locale);
    }
}
