package projects.shiro.education101.fragments.STT;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


public class STTFragment extends Fragment implements STTView {

    private STTPresenter presenter;

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

    @OnClick(R.id.btnListen)
    void listenToAudio(){
        showText();
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
        if(BuildConfig.FLAVOR.equals("Paid")){
            paidView();
        }else {
            freeView();
        }
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
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
