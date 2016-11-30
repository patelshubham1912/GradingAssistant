package com.shubham.gradingassistant;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.shubham.Beans.admin_view;
import com.shubham.DAO.RegisterForDegeePlanFragmentBackgroundTask;
import com.shubham.DAO.StudentActivityBackgroundTask;

/**
 * Created by $hubham on 27/11/2016.
 */

public class RegisterForDegreePlanActivity extends Activity {
    TextView register_for_degree_specialization;
    TextView register_for_degree_major;

    Button register_degree_plan_register;

    Spinner spinner1, spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerfordegreeplan);

        Intent i1 = getIntent();
        final admin_view admin_view = (admin_view) i1.getSerializableExtra("admin_view");
        register_for_degree_specialization = (TextView) findViewById(R.id.register_for_degree_specialization);
        register_for_degree_major = (TextView) findViewById(R.id.register_for_degree_major);
        spinner1 = (Spinner) findViewById(R.id.register_for_degree_major_spinner);
        spinner2 = (Spinner) findViewById(R.id.register_for_degree_specialization_spinner);
        register_degree_plan_register = (Button) findViewById(R.id.register_for_degree_register);

        register_degree_plan_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String specialization_type = spinner1.getSelectedItem().toString();
                String major_type = spinner2.getSelectedItem().toString();
                //String user_id = spinner2.getSelectedItem().toString();
                RegisterForDegeePlanFragmentBackgroundTask backgroundTask = new RegisterForDegeePlanFragmentBackgroundTask(getBaseContext(), new RegisterForDegeePlanFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getBaseContext(), output, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), RegisterForCourseActivity.class);
                        intent.putExtra("admin_view", admin_view);
                        startActivity(intent);

                    }
                });

                SessionManager sessionManger = new SessionManager(getBaseContext());
                admin_view userData = sessionManger.getUserDetails();
                String user_id = userData.getUser_id();
                //Toast.makeText(getContext(),user_id,Toast.LENGTH_SHORT).show();
                backgroundTask.execute(specialization_type, major_type, user_id );
            }
        });

Toast.makeText(getBaseContext(),"Reached",Toast.LENGTH_SHORT).show();
    }

}
