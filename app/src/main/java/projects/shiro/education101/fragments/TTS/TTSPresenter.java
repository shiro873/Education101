package projects.shiro.education101.fragments.TTS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import projects.shiro.utillibrary.TTS;

import static android.app.Activity.RESULT_OK;

public class TTSPresenter implements TTSModel {

    TTS tts;
    private Context context;
    private Activity activity;
    private String filePath;
    private String msgString;

    public TTSPresenter(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
        tts = TTS.newInstance(activity);
    }

    public void speak(String msg){
        tts.Speak(msg);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1 && resultCode == RESULT_OK) {
            filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            // Do anything with file
        }
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile (String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }


    @Override
    public void selectFile() {
        new MaterialFilePicker()
                .withActivity(activity)
                .withRequestCode(1)
                .withFilter(Pattern.compile(".*\\.txt$")) // Filtering files and directories by file name using regexp
                .withFilterDirectories(true) // Set directories filterable (false by default)
                .withHiddenFiles(true) // Show hidden files and folders
                .start();
    }

    @Override
    public void readFromFile() {
        try{
            msgString = getStringFromFile(filePath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveAsAudio() {
        tts.SaveAsAudio(msgString);
    }
}
