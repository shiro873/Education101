package projects.shiro.education101.activity;

import android.app.Application;
import android.arch.persistence.room.Room;

import java.util.List;


import projects.shiro.education101.db.Edu101DB;
import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.service.WordServicePresenter;

public class AppStart extends Application {

    WordServicePresenter presenter;

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
