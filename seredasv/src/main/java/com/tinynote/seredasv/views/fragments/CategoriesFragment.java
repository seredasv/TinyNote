package com.tinynote.seredasv.views.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tinynote.seredasv.R;
import com.tinynote.seredasv.models.categories.CategoriesModel;
import com.tinynote.seredasv.views.activities.MainActivity;
import com.tinynote.seredasv.views.adapters.CategoriesAdapter;

import java.util.LinkedList;

public class CategoriesFragment extends Fragment {
    private static final String TITLE = "toolbar_title";

    private static String title;
    private RecyclerView recyclerView;
    private CategoriesAdapter adapter;

    public static CategoriesFragment newInstance(String title) {
        CategoriesFragment fragment = new CategoriesFragment();

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
        adapter = new CategoriesAdapter(getActivity(), getFakeData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    private LinkedList<CategoriesModel> getFakeData() {
        LinkedList<CategoriesModel> categories = new LinkedList<>();
        categories.add(new CategoriesModel(0, "one", 10));
        categories.add(new CategoriesModel(1, "two", 20));
        categories.add(new CategoriesModel(2, "three", 30));

        return categories;
    }
}
