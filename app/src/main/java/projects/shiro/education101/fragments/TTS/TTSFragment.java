package projects.shiro.education101.fragments.TTS;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.shiro.education101.BuildConfig;
import projects.shiro.education101.R;


public class TTSFragment extends Fragment implements TTSView{

    TTSPresenter presenter;

    @BindView(R.id.txtSpeechInput)
    TextView txtSpeechInput;
    @BindView(R.id.btnSpeak)
    ImageButton btnSpeak;
    @BindView(R.id.btnAddText)
    ImageButton btnAddtext;

    @OnClick(R.id.btnAddText)
    void AddText(){
        selectFileView();
    }

    @OnClick(R.id.btnSpeak)
    void SpeakText(){
        speak();
    }


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
        View view = inflater.inflate(R.layout.fragment_tt, container, false);
        ButterKnife.bind(this, view);
        presenter = new TTSPresenter(this.getContext(), getActivity());
        if(BuildConfig.FLAVOR.equals("paidVersion")){
            paidView();
        }else {
            freeView();
        }
        return view;
    }

    @Override
    public void paidView() {
        btnAddtext.setVisibility(View.VISIBLE);
    }

    @Override
    public void freeView() {
        btnAddtext.setVisibility(View.INVISIBLE);
    }

    @Override
    public void selectFileView() {
        presenter.selectFile();
    }

    @Override
    public void speak() {
        presenter.speak(txtSpeechInput.getText().toString());
    }

    @Override
    public void generateAudio() {
        presenter.saveAsAudio();
    }
}
