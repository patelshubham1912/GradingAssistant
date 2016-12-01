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
import com.shubham.DAO.RegistercourseFragmentBackgroundTask;
import com.shubham.DAO.StudentActivityBackgroundTask;

/**
 * Created by $hubham on 27/11/2016.
 */

public class RegisterForCourseActivity extends Activity {
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercourse);

        Intent i1 = getIntent();
        final admin_view admin_view = (admin_view) i1.getSerializableExtra("admin_view");
        spinner1 = (Spinner)findViewById(R.id.registercourse_spinner);
        spinner2 = (Spinner)findViewById(R.id.registercourse_spinner2);
        spinner3 = (Spinner)findViewById(R.id.registercourse_spinner3);
        registerButton =(Button)findViewById(R.id.registercourse_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinner1text=spinner1.getSelectedItem().toString();
                String spinner2text=spinner2.getSelectedItem().toString();
                String spinner3text=spinner3.getSelectedItem().toString();

                SessionManager sessionManger = new SessionManager(getBaseContext());
                final admin_view admin_view=sessionManger.getUserDetails();
                String userid=admin_view.getUser_id().trim();
                RegistercourseFragmentBackgroundTask backgroundTask = new RegistercourseFragmentBackgroundTask(getBaseContext(), new RegistercourseFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getBaseContext(),output,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        intent.putExtra("admin_view", admin_view);
                        startActivity(intent);

                    }
                });
                backgroundTask.execute(spinner1text,spinner2text,spinner3text,userid);
            }
        });


    }

}
