package projects.shiro.education101.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.service.WordServicePresenter;

@Database(entities = {ObscureWord.class}, version = 1, exportSchema = false)
public abstract class Edu101DB extends RoomDatabase{
    public abstract ObscureWordsDAO wordsDAO();

    private static Edu101DB INSTANCE;

    public static Edu101DB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (Edu101DB.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Edu101DB.class, "Edu-db")
                            .addCallback(new Callback() {
                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    WordServicePresenter presenter = new WordServicePresenter(context);
                                    List<ObscureWord> words = presenter.getWordFromJsonFile();
                                    final ObscureWord[] obscureWords = words.toArray(new ObscureWord[words.size()]);
                                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            INSTANCE.wordsDAO().insertAll(obscureWords);
                                        }
                                    });
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
