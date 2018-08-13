package projects.shiro.education101.activity.Splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import projects.shiro.education101.BuildConfig;
import projects.shiro.education101.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView txt = (TextView)findViewById(R.id.txt);
        if(BuildConfig.FLAVOR.equals("freeVersion")){
            txt.setText("free version");
        }else {
            txt.setText("Paid version");
        }
    }
}
