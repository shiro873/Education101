package projects.shiro.education101.fragments.TTS;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projects.shiro.education101.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TTSFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TTSFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TTSFragment extends Fragment {

    public TTSFragment() {
        // Required empty public constructor
    }


    public static TTSFragment newInstance() {
        TTSFragment fragment = new TTSFragment();
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
        return inflater.inflate(R.layout.fragment_tt, container, false);
    }
}
