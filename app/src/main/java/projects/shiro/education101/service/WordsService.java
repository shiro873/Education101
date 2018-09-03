package projects.shiro.education101.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class WordsService extends Service {
    public WordsService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
