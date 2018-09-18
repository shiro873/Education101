package projects.shiro.education101.fragments.STT;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import projects.shiro.utillibrary.STT;

public class STTPresenter implements STTModel {
    private Context context;
    private Activity activity;
    STT stt;

    public STTPresenter(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
        stt = STT.newInstance(activity);
    }


    @Override
    public void showText() {
        stt.promptSpeechInput();
    }

    @Override
    public void selectAudioFile() {

    }

    @Override
    public String onActivityResult(int requestCode, int resultCode, Intent data) {
         return stt.onActivityResult(requestCode, resultCode, data);
    }
}
