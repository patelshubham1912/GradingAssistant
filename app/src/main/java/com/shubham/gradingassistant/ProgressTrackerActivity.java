package com.shubham.gradingassistant;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.LoginActivityBackgroundTask;
import com.shubham.DAO.ProgressTrackerBackgroundTask;

/**
 * Created by neha_shet on 11/30/2016.
 */

public class ProgressTrackerActivity extends Activity{

    Context ctx=this;
    TextView textViewMajorType,textViewSpecialization,textViewCourse3,textViewCourse2,textViewCourse1,progressTracker_credits,progressTracker_gpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresstracker);

        textViewMajorType = (TextView)findViewById(R.id.textViewMajorType);
        textViewSpecialization = (TextView)findViewById(R.id.textViewSpecialization);
        textViewCourse3 = (TextView)findViewById(R.id.textViewCourse3);
        textViewCourse2 = (TextView)findViewById(R.id.textViewCourse2);
        textViewCourse1 = (TextView)findViewById(R.id.textViewCourse1);
        progressTracker_credits = (TextView)findViewById(R.id.progressTracker_credits);
        progressTracker_gpa = (TextView)findViewById(R.id.progressTracker_gpa);


        ProgressTrackerBackgroundTask backgroundTask=new ProgressTrackerBackgroundTask(ctx, new ProgressTrackerBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {

                Toast.makeText(getBaseContext(),output,Toast.LENGTH_SHORT).show();
                String str[] = output.split("#");
                String courses[] = str[0].split("\\$");



                textViewMajorType.setText(str[1]);
                textViewSpecialization.setText(str[2]);
                progressTracker_credits.setText(str[3]);
                 progressTracker_gpa.setText(str[4]);
                textViewCourse1.setText(courses[0]);
               textViewCourse2.setText(courses[1]);
                textViewCourse3.setText(courses[2]);

            }
        });
        SessionManager sessionManager = new SessionManager(getBaseContext());
        admin_view admin_view  = sessionManager.getUserDetails();

        backgroundTask.execute(admin_view.getUser_id().trim());

    }




    }

