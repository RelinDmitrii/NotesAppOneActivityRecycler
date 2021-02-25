package com.example.notesapponeactivityrecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NotesDetailFragment extends Fragment {

    public static final String ARG_INDEX = "arg_index_notes_detail_fragment";

    public TextView titleNotesDetail;
    public TextView dataNotesDetail;
    public EditText descriptionNotesDetail;

    public static NotesDetailFragment newInstance(int index, String title, String description, String data) {
        NotesDetailFragment fragment = new NotesDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_INDEX, index);
        bundle.putString("title", title);
        bundle.putString("description", description);
        bundle.putString("data", data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmnet_notes_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    public void initList(View view) {
        titleNotesDetail = view.findViewById(R.id.tv_title_nd);
        dataNotesDetail = view.findViewById(R.id.tv_data_nd);
        descriptionNotesDetail = view.findViewById(R.id.et_description_nd);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            String title = getArguments().getString("title");
            String description = getArguments().getString("description");
            String data = getArguments().getString("data");
            titleNotesDetail.setText(title);
            dataNotesDetail.setText(data);
            descriptionNotesDetail.setText(description);
        }
    }

}
