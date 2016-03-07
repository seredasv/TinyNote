package com.tinynote.seredasv.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.models.tags.TagsModel;
import com.tinynote.seredasv.views.activities.MainActivity;
import com.tinynote.seredasv.views.adapters.TagsAdapter;

import java.util.LinkedList;

public class TagsFragment extends Fragment {
    private static final String TITLE = "toolbar_title";

    private static String title;
    private RecyclerView recyclerView;
    private TagsAdapter adapter;

    public static TagsFragment newInstance(String title) {
        TagsFragment fragment = new TagsFragment();

        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = getArguments().getString(TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        findView(view);

        ((MainActivity) getActivity()).toolbar.setTitle(title);

        createRecyclerView();

        return view;
    }

    private void createRecyclerView() {
        adapter = new TagsAdapter(getFakeData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    private LinkedList<TagsModel> getFakeData() {
        LinkedList<TagsModel> categories = new LinkedList<>();
        categories.add(new TagsModel(0, "one"));
        categories.add(new TagsModel(1, "two"));
        categories.add(new TagsModel(2, "three"));

        return categories;
    }
}
