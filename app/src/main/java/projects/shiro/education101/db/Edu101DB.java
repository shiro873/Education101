package projects.shiro.education101.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.RoomDatabase;

import projects.shiro.education101.models.ObscureWord;

@Database(entities = ObscureWord.class, version = 1, exportSchema = false)
public abstract class Edu101DB extends RoomDatabase{
    public abstract ObscureWordsDAO wordsDAO();
}
