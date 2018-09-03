package projects.shiro.education101.fragments.Words;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.shiro.education101.R;
import projects.shiro.education101.adapter.ExpandableAdapter;
import projects.shiro.education101.models.ObscureWord;

public class WordsFragment extends Fragment implements WordsView{

    ExpandableAdapter expandableAdapter;
    List<String> listHeader;
    HashMap<String, List<ObscureWord>> listDataChild;

    @BindView(R.id.expandable_view)
    ExpandableListView expandableListView;


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
        initListView();

        return view;
    }

    @Override
    public void paidView() {

    }

    @Override
    public void freeView() {

    }

    @Override
    public void showTodaysWord() {

    }

    @Override
    public void showArchive() {

    }

    @Override
    public void initListView() {
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
