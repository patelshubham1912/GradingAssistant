package com.shubham.gradingassistant;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.Beans.course;
import com.shubham.DAO.viewgradesFragmentBackgroundTask;

import org.w3c.dom.Text;


public class viewgradesFragment extends Fragment {
    TextView assignmentView, quizView, projectView, midtermView, finalView;
    String s[];
    TextView cId,sId;

    public viewgradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View v=  inflater.inflate(R.layout.activity_viewgrades, container, false);
        SessionManager sessionManger = new SessionManager(getContext());
        course course = sessionManger.getCourse();
        admin_view admin_view= sessionManger.getUserDetails();
        cId=(TextView)v.findViewById(R.id.viewgrades_courseId);
        sId=(TextView)v.findViewById(R.id.viewgrades_studId);
        final String courseId=course.getCourse_id();
        final String studentId=admin_view.getUser_id().trim();
        cId.setText("Course Id:"+courseId);
        sId.setText("Student Id:"+studentId);


        viewgradesFragmentBackgroundTask backgroundTask = new viewgradesFragmentBackgroundTask(getContext(), new viewgradesFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                assignmentView=(TextView)v.findViewById(R.id.viewgrades_Assignment);
                quizView=(TextView)v.findViewById(R.id.viewgrades_Quiz);
                projectView=(TextView)v.findViewById(R.id.viewgrades_Project);
                midtermView=(TextView)v.findViewById(R.id.viewgrades_Midterm);
                finalView=(TextView)v.findViewById(R.id.viewgrades_Final);
                if(!output.trim().equals("0")) {
                    s = output.split("#");

                    assignmentView.setText("Assignment: " + s[0]);
                    quizView.setText("Quiz: " + s[1]);
                    projectView.setText("Project: " + s[2]);
                    midtermView.setText("Midterm: " + s[3]);
                    finalView.setText("Final: " + s[4]);
                }
                else{
                    Toast.makeText(getContext(), output + "", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backgroundTask.execute(studentId,courseId);

        return v;

    }

}
