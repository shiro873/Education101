package projects.shiro.education101.fragments.STT;

import android.content.Intent;

public interface STTModel {
    void showText();
    void selectAudioFile();
    String onActivityResult(int requestCode, int resultCode, Intent data);
}
