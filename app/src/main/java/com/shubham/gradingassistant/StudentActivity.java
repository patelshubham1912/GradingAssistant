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

import com.shubham.Beans.admin_view;
import com.shubham.DAO.StudentActivityBackgroundTask;

/**
 * Created by $hubham on 27/11/2016.
 */

public class StudentActivity extends Activity {
    Button notificationsButton;
    String str[];
    String s[];
    String cs[];
    Button course1;
    Button course2;
    Button course3;
    TextView gpaText;
    Button progress_tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        Intent i1 = getIntent();
       final admin_view admin_view = (admin_view) i1.getSerializableExtra("admin_view");
        notificationsButton = (Button) findViewById(R.id.fragment_first_notifications);
        StudentActivityBackgroundTask backgroundTask = new StudentActivityBackgroundTask(this, new StudentActivityBackgroundTask.AsyncResponse() {
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
                course1 = (Button)findViewById(R.id.fragment_first_course1);
                course2 = (Button)findViewById(R.id.fragment_first_course2);
                course3 = (Button)findViewById(R.id.fragment_first_course3);
                gpaText = (TextView) findViewById(R.id.fragment_first_gpa);
                progress_tracker = (Button)findViewById(R.id.progress_tracker);
                course1.setText(cs[0]);
                course2.setText(cs[1]);
                course3.setText(cs[2]);
                gpaText.setText(cs[cs.length-1].substring(0,4));

                course1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                        intent.putExtra("admin_view", admin_view);
                        startActivity(intent);
                    }
                });

                course2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                        intent.putExtra("admin_view", admin_view);
                        startActivity(intent);
                    }
                });

                course3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                        intent.putExtra("admin_view", admin_view);
                        startActivity(intent);
                    }
                });
                progress_tracker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getBaseContext(),ProgressTrackerActivity.class);
                        startActivity(intent);


                    }
                });

            }
        });
        backgroundTask.execute(admin_view.getUser_id().replaceAll("\\s",""));


    }

}
