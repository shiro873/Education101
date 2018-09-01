package projects.shiro.education101.fragments.STT;

import android.content.Intent;

public interface STTModel {
    void showText();
    void selectAudioFile();
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
