package projects.shiro.education101.activity;

import android.app.Application;
import android.arch.persistence.room.Room;

import projects.shiro.education101.db.Edu101DB;

public class AppStart extends Application {
    Edu101DB db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), Edu101DB.class, "Edu-DB").build();
    }

    public Edu101DB getDB(){
        return db;
    }
}
