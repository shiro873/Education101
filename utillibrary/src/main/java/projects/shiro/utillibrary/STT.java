package projects.shiro.utillibrary;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class STT {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private Activity activity;
    private static STT INSTANCE = null;


    private STT(Activity activity){
        this.activity = activity;
    }

    public static synchronized STT newInstance(Activity activity){
        if(INSTANCE == null){
            INSTANCE = new STT(activity);
        }
        return INSTANCE;
    }

    public void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        //intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
               // activity.getString(R.string.speech_prompt));
        /*try {
            activity.startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(activity.getApplicationContext(),
                    activity.getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }*/
        activity.startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
    }

    public String onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    return result.get(0);
                }
                break;
            }
        }
        return "";
    }
}
