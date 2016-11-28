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
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.shubham.Beans.admin_view;
import com.shubham.DAO.StudentActivityBackgroundTask;

/**
 * Created by $hubham on 27/11/2016.
 */

public class StudentActivity extends Activity {
    Button notificationsButton;

    String s[];

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
                s = output.split("#");

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
                //courseDescription.setText(output);

            }
        });
        backgroundTask.execute(admin_view.getUser_id().replaceAll("\\s",""));


    }

}
