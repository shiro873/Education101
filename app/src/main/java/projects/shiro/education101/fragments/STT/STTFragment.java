package projects.shiro.education101.fragments.STT;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projects.shiro.education101.R;


public class STTFragment extends Fragment {

    public STTFragment() {
        // Required empty public constructor
    }

    public static STTFragment newInstance() {
        STTFragment fragment = new STTFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stt, container, false);
    }
}
