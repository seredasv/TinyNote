package com.tinynote.seredasv.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tinynote.seredasv.R;

public class NotesFragment extends Fragment {
    private static final String TOOLBAR_TITLE = "toolbar_title";

    private static String toolbarTitle;

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

        toolbarTitle = getArguments().getString(TOOLBAR_TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        return view;
    }
}
