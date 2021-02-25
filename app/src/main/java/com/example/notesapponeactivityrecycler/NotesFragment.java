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

import java.util.ArrayList;
import java.util.Arrays;

public class NotesFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_INDEX = "arg_index_notes_fragment";

    ArrayList<Note> notes = new ArrayList<>(Arrays.asList(new Note("Парикмахер", "Подстричься", "16.02.02"),
            new Note("Рабочая встреча", "Встреча с представителем банка", "18.02.02"), new Note("Прогулка", "Прогулка на велосипедах", "20.02.02")));

    private TextView tvTitle1;
    private TextView tvTitle2;
    private TextView tvTitle3;
    private TextView tvDescription1;
    private TextView tvDescription2;
    private TextView tvDescription3;
    private TextView tvData1;
    private TextView tvData2;
    private TextView tvData3;
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;

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
        initList(view);
        setList(view);
        cardsInitAndSetClick(view);
    }

    public void initList(View view) {
        tvTitle1 = view.findViewById(R.id.tv_title_1);
        tvTitle2 = view.findViewById(R.id.tv_title_2);
        tvTitle3 = view.findViewById(R.id.tv_title_3);
        tvDescription1 = view.findViewById(R.id.tv_description_1);
        tvDescription2 = view.findViewById(R.id.tv_description_2);
        tvDescription3 = view.findViewById(R.id.tv_description_3);
        tvData1 = view.findViewById(R.id.tv_data_1);
        tvData2 = view.findViewById(R.id.tv_data_2);
        tvData3 = view.findViewById(R.id.tv_data_3);
    }

    public void setList(View view) {
        tvTitle1.setText(notes.get(0).title);
        tvTitle2.setText(notes.get(1).title);
        tvTitle3.setText(notes.get(2).title);
        tvDescription1.setText(notes.get(0).description);
        tvDescription2.setText(notes.get(1).description);
        tvDescription3.setText(notes.get(2).description);
        tvData1.setText(notes.get(0).data);
        tvData2.setText(notes.get(1).data);
        tvData3.setText(notes.get(2).data);
    }

    public void cardsInitAndSetClick(View view) {
        cardView1 = view.findViewById(R.id.cv_1);
        cardView2 = view.findViewById(R.id.cv_2);
        cardView3 = view.findViewById(R.id.cv_3);
        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.cv_1): {
                startNotesDetailActivity(0);
                break;
            }
            case (R.id.cv_2): {
                startNotesDetailActivity(1);
                break;
            }
            case (R.id.cv_3): {
                startNotesDetailActivity(2);
                break;
            }
        }
    }


    private void startNotesDetailActivity(int index) {
        NotesDetailFragment fragment = NotesDetailFragment.newInstance(index, notes.get(index).title, notes.get(index).description, notes.get(index).data);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("save")
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
