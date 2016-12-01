package com.shubham.gradingassistant;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.ProfessorActivityBackgroundTask;

/**
 * Created by $hubham on 27/11/2016.
 */

public class ProfessorActivity extends Activity {
    Button notificationsButton;
    String str[];
    String s[];
    String cs[];
    Button course1;
    Button course2;
    Button course3;
    admin_view admin_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

//        Intent i1 = getIntent();
//       final admin_view admin_view = (admin_view) i1.getSerializableExtra("admin_view");
        SessionManager sessionManger = new SessionManager(getBaseContext());
        admin_view=sessionManger.getUserDetails();
        notificationsButton = (Button) findViewById(R.id.fragment_second_notifications);
        ProfessorActivityBackgroundTask backgroundTask = new ProfessorActivityBackgroundTask(this, new ProfessorActivityBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {

                int temp = 0;
                str=output.split("\\%");
                s = str[0].split("#");
                cs = str[1].split("\\$");
                temp = Integer.parseInt(s[0].replaceAll("[\\D]", ""));
                if (temp > 0) {
                    notificationsButton.setText("Notifications\n(" + temp + "" + ")");
                    notificationsButton.setBackgroundColor(Color.RED);
                    notificationsButton.setTextColor(Color.WHITE);

                    for(int i=0;i<temp;i++) {
                        String s1[] = s[i + 1].toString().split("\\$");

                        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getBaseContext()).setSmallIcon(R.drawable.ic_action_name).setContentTitle(s1[0]).setContentInfo(s1[1]).setContentText(s1[2]);

                        notificationManager.notify(i, notificationBuilder.build());
                    }

                }

                //Courses and average gpa
                course1 = (Button)findViewById(R.id.fragment_second_course1);
                course2 = (Button)findViewById(R.id.fragment_second_course2);
                course3 = (Button)findViewById(R.id.fragment_second_course3);

                course1.setText(cs[0]);
                course2.setText(cs[1]);
                course3.setText(cs[2]);

                course1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SessionManager sessionManger = new SessionManager(getBaseContext());
                        sessionManger.createCourse(course1.getText().toString());
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                       // intent.putExtra("admin_view", admin_view);
                        startActivity(intent);
                    }
                });

                course2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SessionManager sessionManger = new SessionManager(getBaseContext());
                        sessionManger.createCourse(course2.getText().toString());
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                       // intent.putExtra("admin_view", admin_view);
                        startActivity(intent);
                    }
                });

                course3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SessionManager sessionManger = new SessionManager(getBaseContext());
                        sessionManger.createCourse(course3.getText().toString());
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                     //   intent.putExtra("admin_view", admin_view);
                        startActivity(intent);
                    }
                });

            }
        });
        backgroundTask.execute(admin_view.getUser_id().replaceAll("\\s",""));


    }

}
