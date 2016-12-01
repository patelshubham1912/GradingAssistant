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

import com.shubham.Beans.course;
import com.shubham.DAO.avggpaFragmentBackgroundTask;

import org.w3c.dom.Text;


public class avggpaFragment extends Fragment {

    TextView avgclassgpa;
    public avggpaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_avggpa, container, false);

        SessionManager sessionManger = new SessionManager(getContext());
        course course = sessionManger.getCourse();
        final String courseId=course.getCourse_id().trim();
        avgclassgpa = (TextView)v.findViewById(R.id.avgclassgpa);

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
