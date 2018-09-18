package projects.shiro.education101.fragments.Words;

import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import projects.shiro.education101.models.ObscureWord;

public interface WordsModel {
    LiveData<ObscureWord> getTodaysWord();
    void saveWords(ObscureWord word);
    LiveData<List<ObscureWord>> getWords();
    LiveData<ObscureWord> getWord();
}
