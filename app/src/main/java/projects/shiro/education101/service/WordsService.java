package projects.shiro.education101.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import projects.shiro.education101.fragments.Words.WordsPresenter;

public class WordsService extends Service {

    WordsPresenter presenter;

    public WordsService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        presenter = new WordsPresenter(getApplicationContext());
        
    }
}
