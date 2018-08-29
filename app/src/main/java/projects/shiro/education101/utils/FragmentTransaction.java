package projects.shiro.education101.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class FragmentTransaction {
    AppCompatActivity activity;
    public FragmentTransaction(AppCompatActivity activity){
        this.activity = activity;
    }

    protected void setFragment(Fragment fragment, int id) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(id, fragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }
}
