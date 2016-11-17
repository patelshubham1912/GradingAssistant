package com.shubham.gradingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddslidesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddslidesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddslidesFragment extends Fragment {

    public AddslidesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_addslide, container, false);

    }

}
