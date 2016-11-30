package com.shubham.gradingassistant;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.DAO.avggpaFragmentBackgroundTask;


public class avggpaFragment extends Fragment {

    EditText avgclassgpa;
    TextView course_name;
    public avggpaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_avggpa, container, false);
        course_name = (TextView)v.findViewById(R.id.avg_course_name);

        final String courseId="C001";
        course_name.setText("Average Class GPA for "+courseId);
        avgclassgpa = (EditText)v.findViewById(R.id.avgclassgpa);

        avggpaFragmentBackgroundTask backgroundTask = new avggpaFragmentBackgroundTask(getContext(), new avggpaFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                avgclassgpa.setText(output);
                Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
            }
        });
        backgroundTask.execute(courseId);


        return v;

    }

}
