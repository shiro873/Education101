package projects.shiro.education101.fragments.Words;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import projects.shiro.education101.BuildConfig;
import projects.shiro.education101.R;
import projects.shiro.education101.adapter.ExpandableAdapter;
import projects.shiro.education101.models.ObscureWord;
import projects.shiro.education101.service.WordServiceModel;

public class WordsFragment extends Fragment implements WordsView{

    private WordsPresenter presenter;
    ExpandableAdapter expandableAdapter;
    List<String> listHeader;
    HashMap<String, List<ObscureWord>> listDataChild;
    private ObscureWord wordOfTheDay;

    @BindView(R.id.expandable_view)
    ExpandableListView expandableListView;
    @BindView(R.id.obscure_word)
    TextView obscureWord;
    @BindView(R.id.words_meaning)
    TextView obscureWordMeaning;

    WordsViewModel model;

    private WordServiceModel wordServiceModel;


    public WordsFragment() {
        // Required empty public constructor
    }


    public static WordsFragment newInstance() {
        WordsFragment fragment = new WordsFragment();
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
        View view = inflater.inflate(R.layout.fragment_words, container, false);
        ButterKnife.bind(this, view);
        //presenter= new WordsPresenter(getContext(), getActivity().getApplication());
        String header = "Archove";
        listHeader = new ArrayList<>();
        listHeader.add(header);

        model = ViewModelProviders.of(this.getActivity()).get(WordsViewModel.class);

        //listDataChild = presenter.getWords();
        if(BuildConfig.FLAVOR.equals("paidVersion")){
            initListView();
            paidView();
        }else {
            freeView();
            //showTodaysWord();
            model.getWordLiveData().observe(this, new Observer<ObscureWord>() {
                @Override
                public void onChanged(@Nullable ObscureWord word) {
                    if(word != null){
                        obscureWord.setText(word.getWord());
                        obscureWordMeaning.setText(word.getWordDefinition());
                        wordOfTheDay = word;
                    }
                }
            });
            model.updateWordOfTheDay(wordOfTheDay);
        }

        return view;
    }

    @Override
    public void paidView() {
        expandableListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void freeView() {
        expandableListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showTodaysWord() {

    }

    @Override
    public void showArchive() {

    }

    @Override
    public void initListView() {
        listDataChild = new HashMap<>();
        expandableAdapter = new ExpandableAdapter(this.getContext(), listHeader, listDataChild);
        expandableListView.setAdapter(expandableAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(),
                        listHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getContext(),
                        listHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getContext(),
                        listHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }
}
