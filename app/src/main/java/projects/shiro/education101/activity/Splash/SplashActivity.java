package projects.shiro.education101.activity.Splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import projects.shiro.education101.BuildConfig;
import projects.shiro.education101.R;
import projects.shiro.education101.activity.Home.MasterActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle("");
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }

        Intent intent = new Intent(SplashActivity.this, MasterActivity.class);
        startActivity(intent);
    }
}
