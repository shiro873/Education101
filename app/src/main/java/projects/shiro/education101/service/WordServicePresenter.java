package projects.shiro.education101.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import projects.shiro.education101.db.Edu101DB;
import projects.shiro.education101.models.ObscureWord;

public class WordServicePresenter implements WordServiceModel {
    Context context;
    Edu101DB db;
    ObscureWord word;

    public WordServicePresenter(Context context){
        this.context = context;
    }

    @Override
    public ObscureWord getWordFromJsonFile() {
        String json = loadJSONFromAsset();
        Gson gson = new Gson();
        List<ObscureWord> obscureWords = gson.fromJson(json, new TypeToken<List<ObscureWord>>(){}.getType());
        return obscureWords.get(0);
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
                db.wordsDAO().insert(word);
            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("a.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
