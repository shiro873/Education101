package projects.shiro.education101.activity.Splash;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import projects.shiro.education101.BuildConfig;
import projects.shiro.education101.R;
import projects.shiro.education101.activity.Home.MasterActivity;
import projects.shiro.education101.broadcastreciever.AlarmManagerBoradcastReceiver;
import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.service.WordServicePresenter;

public class SplashActivity extends AppCompatActivity {

    AlarmManagerBoradcastReceiver receiver;
    WordServicePresenter presenter;
    SplashViewModel splashViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle("");

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);

        receiver = new AlarmManagerBoradcastReceiver();
        startRepeating();

        final TextView textView = findViewById(R.id.txt);

        Intent intent = new Intent(SplashActivity.this, MasterActivity.class);
        startActivity(intent);
    }

    private void showToast(List<ObscureWord> words) {
        Toast.makeText(this, words.get(1).getWord(), Toast.LENGTH_LONG).show();
    }

    public void startRepeating(){
        Context context = this.getApplicationContext();
        if(receiver != null){
            receiver.setAlarm(context);
        }else {
            Toast.makeText(context, "alarm is null", Toast.LENGTH_LONG);
        }
    }

    public void cancelRepeatingTimer(View view){
        Context context = this.getApplicationContext();
        if(receiver != null){
            receiver.cancelAlarm(context);
        }
        else{
            Toast.makeText(context, "alarm is null", Toast.LENGTH_LONG);
        }
    }

    public void onetimeTimer(View view){
        Context context = this.getApplicationContext();
        if(receiver != null){
            receiver.setOneTimeTimer(context);
        }
        else{
            Toast.makeText(context, "alarm is null", Toast.LENGTH_LONG);
        }
    }
}
