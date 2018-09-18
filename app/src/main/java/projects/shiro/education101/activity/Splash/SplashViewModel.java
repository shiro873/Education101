package projects.shiro.education101.activity.Splash;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.repository.ObscureRepository;

public class SplashViewModel extends AndroidViewModel {

    ObscureRepository repository;
    LiveData<List<ObscureWord>> allWords;

    public SplashViewModel(@NonNull Application application) {
        super(application);
        repository = new ObscureRepository(application);
        allWords = repository.getAllWords();
    }

    public void insert(List<ObscureWord> words){
        if(words != null){
            for (ObscureWord word: words
                 ) {
                //repository.insert(word);
            }
        }
    }

    public LiveData<List<ObscureWord>> getAllWords(){
        return allWords;
    }
}
