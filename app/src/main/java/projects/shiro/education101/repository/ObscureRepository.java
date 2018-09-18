package projects.shiro.education101.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import io.reactivex.Single;
import projects.shiro.education101.db.Edu101DB;
import projects.shiro.education101.db.ObscureWordsDAO;
import projects.shiro.education101.models.ObscureWord;

public class ObscureRepository {
    private ObscureWordsDAO wordsDAO;
    LiveData<ObscureWord> wordOfTheDay;
    Single<ObscureWord> wordSingle;
    LiveData<List<ObscureWord>> mAllWords;
    LiveData<List<ObscureWord>> mUsedWords;

    public ObscureRepository(Application application){
        Edu101DB db = Edu101DB.getDatabase(application);
        wordsDAO = db.wordsDAO();
        wordOfTheDay = db.wordsDAO().getTodaysWord();
        mAllWords = db.wordsDAO().getAllWords();
        mUsedWords = db.wordsDAO().geUsedWords();
    }

    public LiveData<ObscureWord> getWordOfTheDay(){
        return wordOfTheDay;
    }

    public LiveData<List<ObscureWord>> getAllWords(){
        return mAllWords;
    }

    public LiveData<List<ObscureWord>> getUsedWords(){
        return mUsedWords;
    }

    public Single<ObscureWord> getWordSingle() {
        return wordSingle;
    }

    public void update(ObscureWord word){
        wordsDAO.update(true, word.getId());
    }
}
