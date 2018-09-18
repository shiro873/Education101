package projects.shiro.education101.fragments.STT;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.shiro.education101.BuildConfig;
import projects.shiro.education101.R;

import static android.app.Activity.RESULT_OK;


public class STTFragment extends Fragment implements STTView {

    private STTPresenter presenter;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @BindView(R.id.txtTextInput)
    TextView txtTextInput;
    @BindView(R.id.btnAddMusic)
    ImageButton btnAddMusic;
    @BindView(R.id.btnListen)
    ImageButton btnListen;

    @OnClick(R.id.btnAddMusic)
    void addMusicFile(){
        generateTextFromAudio();
    }

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
        View view = inflater.inflate(R.layout.fragment_stt, container, false);
        ButterKnife.bind(this, view);
        presenter = new STTPresenter(getContext(), getActivity());
        if(BuildConfig.FLAVOR.equals("paidVersion")){
            paidView();
        }else {
            freeView();
        }

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                promptSpeechInput();
            }
        });
        return view;
    }

    public void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtTextInput.setText(result.get(0));
                }
                break;
            }

        }
    }



    @Override
    public void freeView() {
        btnAddMusic.setVisibility(View.INVISIBLE);
    }

    @Override
    public void paidView() {
        btnAddMusic.setVisibility(View.VISIBLE);
    }

    @Override
    public void showText() {
        presenter.showText();
    }

    @Override
    public void generateTextFromAudio() {
        presenter.selectAudioFile();
    }
}
