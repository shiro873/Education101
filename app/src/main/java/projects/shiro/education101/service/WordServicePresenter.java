package projects.shiro.education101.service;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import projects.shiro.education101.R;
import projects.shiro.education101.db.Edu101DB;
import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.repository.ObscureRepository;

public class WordServicePresenter implements WordServiceModel {
    Context context;
    ObscureRepository repository;
    ObscureWord word;

    public WordServicePresenter(Context context){
        this.context = context;
        //repository = new ObscureRepository(application);
    }

    @Override
    public List<ObscureWord> getWordFromJsonFile() {
        String json = loadJSONFromAsset();
        Gson gson = new Gson();
        List<ObscureWord> obscureWords = gson.fromJson(json, new TypeToken<List<ObscureWord>>(){}.getType());
        return obscureWords;
    }

    @Override
    public ObscureWord getWordFromNetWork() {
        return null;
    }

    @Override
    public void SaveWord(final ObscureWord word) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //repository.insert();
            }
        });
    }

    @Override
    public void saveWords(final List<ObscureWord> words) {
        //repository.insert(word);
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            //InputStream is = context.getAssets().open("a.json");
            InputStream is = context.getResources().openRawResource(R.raw.a);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
