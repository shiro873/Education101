package projects.shiro.education101.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import projects.shiro.education101.models.ObscureWord;

@Dao
public interface ObscureWordsDAO {
    @Insert
    void insert(ObscureWord word);

    @Query("DELETE FROM ObscureWord")
    void deleteAll();

    @Query("SELECT * from ObscureWord")
    List<ObscureWord> getAllWords();

    @Query("SELECT * FROM ObscureWord where IsUsed != 1")
    ObscureWord getTodaysWord();
}
