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
import com.tinynote.seredasv.models.categories.CategoriesModel;
import com.tinynote.seredasv.models.locations.LocationsModel;
import com.tinynote.seredasv.models.notes.NotesModel;
import com.tinynote.seredasv.models.tags.TagsModel;
import com.tinynote.seredasv.views.activities.MainActivity;
import com.tinynote.seredasv.views.adapters.NotesAdapter;
import io.realm.RealmList;

import java.util.Date;
import java.util.LinkedList;

public class NotesFragment extends Fragment {
    private static final String TOOLBAR_TITLE = "toolbar_title";

    private static String title;
    private RecyclerView recyclerView;
    private NotesAdapter adapter;

    public static NotesFragment newInstance(String title) {
        NotesFragment fragment = new NotesFragment();

        Bundle args = new Bundle();
        args.putString(TOOLBAR_TITLE, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = getArguments().getString(TOOLBAR_TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        findView(view);

        ((MainActivity) getActivity()).toolbar.setTitle(title);

        createRecyclerView();

        return view;
    }

    private void createRecyclerView() {
        adapter = new NotesAdapter(getActivity(), getFakeData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void findView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    private LinkedList<NotesModel> getFakeData() {
        LinkedList<NotesModel> notes = new LinkedList<>();
        String content = "very long content here very long content herevery long content here very long content herevery long content here very long content herevery long content herevery long content here  very long content here very long content herevery long content herevery long content herevery long content herevery long content herevery long content here very long content herevery long content here";
        LocationsModel location = new LocationsModel(0, "one", 10.10f, 10.20f, 10.30f);
        CategoriesModel categories = new CategoriesModel(0, "one", "#636161");
        TagsModel tags1 = new TagsModel(0, "one");
        TagsModel tags2 = new TagsModel(1, "two");
        TagsModel tags3 = new TagsModel(2, "three");
        TagsModel tags4 = new TagsModel(3, "fout");
        RealmList<TagsModel> tags = new RealmList<>();
        tags.add(tags1);
        tags.add(tags2);
        tags.add(tags3);
        tags.add(tags4);

        notes.add(new NotesModel(0, "one", content, new Date(), location, categories, tags));
        notes.add(new NotesModel(1, "two", content, new Date(), location, categories, tags));
        notes.add(new NotesModel(2, "three", content, new Date(), location, categories, tags));

        return notes;
    }
}
