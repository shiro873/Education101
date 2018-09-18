package projects.shiro.education101.fragments.Words;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import io.reactivex.Single;
import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.repository.ObscureRepository;

public class WordsViewModel extends AndroidViewModel {

    ObscureRepository repository;
    private Single<ObscureWord> wordSingle;
    private LiveData<ObscureWord> wordLiveData;

    public WordsViewModel(@NonNull Application application) {
        super(application);
        repository = new ObscureRepository(application);
        wordSingle = repository.getWordSingle();
        wordLiveData = repository.getWordOfTheDay();
    }

    Single<ObscureWord> getWordSingle(){
        return wordSingle;
    }

    LiveData<ObscureWord> getWordLiveData(){
        return wordLiveData;
    }

    void updateWordOfTheDay(ObscureWord word){
        //repository.update(word);
    }
}
