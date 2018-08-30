package projects.shiro.education101.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import projects.shiro.education101.fragments.STT.STTFragment;
import projects.shiro.education101.fragments.TTS.TTSFragment;
import projects.shiro.education101.fragments.Words.WordsFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numOfFrags;

    public PagerAdapter(FragmentManager fm, int numOfFrags) {
        super(fm);
        this.numOfFrags = numOfFrags;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TTSFragment();
            case 1:
                return new STTFragment();
            case 2:
                return new WordsFragment();
            default:
                return new TTSFragment();
        }
    }

    @Override
    public int getCount() {
        return numOfFrags;
    }
}
