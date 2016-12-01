package com.shubham.gradingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.Beans.course;
import com.shubham.DAO.viewCourseDescriptionFragmentBackgroundTask;

import org.w3c.dom.Text;


public class viewCourseDescriptionFragment extends Fragment {
    TextView courseIdText;
    TextView courseDescription;
    String s[];
    public viewCourseDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_viewcoursedescription, container, false);

        courseIdText=(TextView)v.findViewById(R.id.viewCourseDescription_courseId);
        courseDescription=(TextView)v.findViewById(R.id.viewCourseDescription_courseDescription);
        SessionManager sessionManger = new SessionManager(getContext());
        course course = sessionManger.getCourse();
        final String courseId=course.getCourse_id();
        viewCourseDescriptionFragmentBackgroundTask backgroundTask = new viewCourseDescriptionFragmentBackgroundTask(getContext(), new viewCourseDescriptionFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                courseDescription.setText(output);
                courseIdText.setText("Course ID : "+courseId);
                Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
            }
        });
        backgroundTask.execute(courseId);
        return v;

    }

}
