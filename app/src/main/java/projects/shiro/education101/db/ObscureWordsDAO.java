package projects.shiro.education101.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import projects.shiro.education101.models.ObscureWord;

@Dao
public interface ObscureWordsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ObscureWord word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ObscureWord... words);

    @Query("DELETE FROM ObscureWord")
    void deleteAll();

    @Query("SELECT * from ObscureWord")
    LiveData<List<ObscureWord>> getAllWords();

    @Query("SELECT * FROM ObscureWord where Used != 1 LIMIT 1")
    LiveData<ObscureWord> getTodaysWord();

    @Query("SELECT * FROM ObscureWord where Used == 1")
    LiveData<List<ObscureWord>> geUsedWords();

    @Query("SELECT * FROM ObscureWord where Used != 1 LIMIT 1")
    Single<ObscureWord> getWordOfTheDay();

    @Query("UPDATE ObscureWord SET Used=:used WHERE Id = :id")
    void update(boolean used, int id);

}
