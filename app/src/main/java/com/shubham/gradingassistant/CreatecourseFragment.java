package com.shubham.gradingassistant;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.CreatecourseFragmentBackgroundTask;
import com.shubham.DAO.LoginActivityBackgroundTask;
import com.shubham.Beans.course;

public class CreatecourseFragment extends Fragment {

    EditText createcourse_course_id;
    EditText createcourse_course_name;
    EditText createcourse_pre_requisite;
    Button createcourse_create;
    Spinner spinner1, spinner2;
    course course = new course();
    public CreatecourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.activity_createcourse, container, false);
        createcourse_course_id  = (EditText) v.findViewById(R.id.createcourse_course_id);
        createcourse_course_name  = (EditText) v.findViewById(R.id.createcourse_course_name);
        createcourse_pre_requisite  = (EditText) v.findViewById(R.id.createcourse_pre_requisite);
        spinner1 = (Spinner)v.findViewById(R.id.createcourse_specialization_type);
        spinner2 = (Spinner)v.findViewById(R.id.createcourse_major_type);
        createcourse_create = (Button) v.findViewById(R.id.createcourse_create);

        createcourse_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                course.setCourse_id(createcourse_course_id.getText().toString());
                course.setCourse_name(createcourse_course_name.getText().toString());
                course.setPre_requisite(createcourse_pre_requisite.getText().toString());
                course.setSpecialization_type(spinner1.getSelectedItem().toString());
                course.setDegree_type(spinner2.getSelectedItem().toString());
                //Toast.makeText(getContext(),spinner2.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                CreatecourseFragmentBackgroundTask backgroundTask = new CreatecourseFragmentBackgroundTask(getContext(),course, new CreatecourseFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();

                    }
                });
                backgroundTask.execute();
            //Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }

}