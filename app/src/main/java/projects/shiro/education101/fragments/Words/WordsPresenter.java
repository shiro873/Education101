package projects.shiro.education101.fragments.Words;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.res.TypedArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import projects.shiro.education101.activity.AppStart;
import projects.shiro.education101.db.Edu101DB;
import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.repository.ObscureRepository;

public class WordsPresenter implements WordsModel {
    Context context;
    ObscureRepository repository;
    ObscureWord word;
    List<ObscureWord> words;

    public WordsPresenter(Context context, Application application){
        this.context = context;
        repository = new ObscureRepository(application);
    }

    @Override
    public LiveData<ObscureWord> getTodaysWord() {
        LiveData<ObscureWord> wordMaybe = repository.getWordOfTheDay();
        return wordMaybe;
    }

    public Single<ObscureWord> getWordOfTheDay(){
        return repository.getWordSingle();
    }

    @Override
    public void saveWords(final ObscureWord word) {

    }

    @Override
    public LiveData<List<ObscureWord>> getWords() {
        return repository.getUsedWords();
    }

    @Override
    public LiveData<ObscureWord> getWord() {
        LiveData<ObscureWord> wordMaybe = repository.getWordOfTheDay();
        return wordMaybe;
    }


}
