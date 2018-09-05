package projects.shiro.education101.fragments.Words;

import android.content.Context;
import android.content.res.TypedArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import projects.shiro.education101.activity.AppStart;
import projects.shiro.education101.db.Edu101DB;
import projects.shiro.education101.models.ObscureWord;

public class WordsPresenter implements WordsModel {
    Context context;
    Edu101DB db;
    ObscureWord word;
    List<ObscureWord> words;

    public WordsPresenter(Context context){
        this.context = context;
    }

    @Override
    public ObscureWord getTodaysWord() {
        return getWord();
    }

    @Override
    public void saveWords(final ObscureWord word) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.wordsDAO().insert(word);
            }
        });
    }

    @Override
    public List<ObscureWord> getWords() {
        words = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                words = db.wordsDAO().getAllWords();
            }
        });
        return words;
    }

    @Override
    public ObscureWord getWord() {
        word = new ObscureWord();
        new Thread(new Runnable() {
            @Override
            public void run() {
                word = db.wordsDAO().getTodaysWord();
            }
        });
        return word;
    }


}
