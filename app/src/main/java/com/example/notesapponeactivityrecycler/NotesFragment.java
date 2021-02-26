package com.example.notesapponeactivityrecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class NotesFragment extends Fragment implements NotesListRvAdapter.OnItemClickListener {

    public static final String ARG_INDEX = "arg_index_notes_fragment";

    RecyclerView recyclerView;
    NotesListRvAdapter notesListRvAdapter;

    public static NotesFragment newInstance(int index) {
        NotesFragment fragment = new NotesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragmnet_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter(view);
    }

    public void initAdapter(View view) {
        recyclerView = view.findViewById(R.id.rv);
        notesListRvAdapter = new NotesListRvAdapter(((MainActivity)getActivity()).notes);
        notesListRvAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(notesListRvAdapter);
    }



    private void startNotesDetailActivity(int index) {
        NotesDetailFragment fragment = NotesDetailFragment.newInstance(index);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("save")
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void onItemClick(View view, int position) {
        startNotesDetailActivity(position);
    }
}
