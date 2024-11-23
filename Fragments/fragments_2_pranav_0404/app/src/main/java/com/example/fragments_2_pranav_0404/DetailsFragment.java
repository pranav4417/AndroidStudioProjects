package com.example.fragments_2_pranav_0404;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    private static final String[] USERS = {"Pranav", "Shubham", "Ravi", "Raju"};
    private static final String[] SECTIONS = {"1", "2", "3", "4"};
    private TextView resultTextView;
    private int position; // Store position

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(int position) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("student_position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the position from arguments
        if (getArguments() != null) {
            position = getArguments().getInt("student_position", -1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_detailsfrag, container, false);
        resultTextView = view.findViewById(R.id.result);
        change(position); // Call change after the TextView is initialized
        return view;
    }

    public void change(int position) {
        if (position >= 0 && position < USERS.length) {
            resultTextView.setText("Name: " + USERS[position] + "\nSection Number: " + SECTIONS[position]);
        } else {
            resultTextView.setText("Invalid selection.");
        }
    }

    public static void switchFragment(Fragment fragment, FragmentTransaction transaction) {
        transaction.replace(R.id.fragmentdet, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
