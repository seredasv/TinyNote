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
import com.tinynote.seredasv.models.locations.LocationsModel;
import com.tinynote.seredasv.models.tags.TagsModel;
import com.tinynote.seredasv.views.activities.MainActivity;
import com.tinynote.seredasv.views.adapters.LocationsAdapter;

import java.util.LinkedList;

public class LocationsFragment extends Fragment {
    private static final String TITLE = "toolbar_title";

    private static String title;
    private RecyclerView recyclerView;
    private LocationsAdapter adapter;

    public static LocationsFragment newInstance(String title) {
        LocationsFragment fragment = new LocationsFragment();

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
        adapter = new LocationsAdapter(getActivity(), getFakeData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    private LinkedList<LocationsModel> getFakeData() {
        LinkedList<LocationsModel> categories = new LinkedList<>();
        categories.add(new LocationsModel(0, "one", 10.10f, 10.20f, 10.30f));
        categories.add(new LocationsModel(1, "two", 10.10f, 10.20f, 10.30f));
        categories.add(new LocationsModel(2, "three", 10.10f, 10.20f, 10.30f));

        return categories;
    }
}
