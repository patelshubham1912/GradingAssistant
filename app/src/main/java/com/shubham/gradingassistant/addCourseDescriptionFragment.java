package com.shubham.gradingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.DAO.*;
import org.w3c.dom.Text;


public class addCourseDescriptionFragment extends Fragment {
    TextView courseId;
    TextView courseDescription;
    Button submit;
    String s[];
    public addCourseDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_addcoursedescription, container, false);
        courseId=(TextView)v.findViewById(R.id.addCourseDescription_courseId);
        courseDescription=(TextView)v.findViewById(R.id.addCourseDescription_courseDescription);
        submit=(Button)v.findViewById(R.id.addCourseDescription_submit);
        final String courseId="C001";
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourseDescriptionFragmentBackgroundTask backgroundTask = new addCourseDescriptionFragmentBackgroundTask(getContext(), new addCourseDescriptionFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(courseId,courseDescription.getText().toString());
            }
        });

        viewCourseDescriptionFragmentBackgroundTask backgroundTask = new viewCourseDescriptionFragmentBackgroundTask(getContext(), new viewCourseDescriptionFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                courseDescription.setText(output);
                Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
            }
        });
        backgroundTask.execute(courseId);
        return v;

    }

}
