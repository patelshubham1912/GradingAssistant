package com.shubham.gradingassistant;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.*;
import org.w3c.dom.Text;

import java.io.File;


public class adminHomeFragment extends Fragment {
    TextView admin_name;
    TextView email;
    TextView role;
    Button notifications;
    String s[];
    admin_view admin_view;
    public adminHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_adminhomescreen, container, false);
        SessionManager sessionManger = new SessionManager(getContext());
        admin_view=sessionManger.getUserDetails();

        admin_name=(TextView) v.findViewById(R.id.admin_name);
        admin_name.setText(admin_view.getUser_name());

        email=(TextView)v.findViewById(R.id.admin_email);
        email.setText(admin_view.getEmail_id());

        role=(TextView)v.findViewById(R.id.admin_role);
        role.setText(admin_view.getUser_type());

        notifications=(Button)v.findViewById(R.id.admin_notifications);


        adminHomeFragmentBackgroundTask backgroundTask = new adminHomeFragmentBackgroundTask(getContext(), new adminHomeFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();

                int temp = 0;
                s = output.split("#");
                temp = Integer.parseInt(s[0].replaceAll("[\\D]", ""));
                if (temp > 0) {
                    notifications.setText("Notifications\n(" + temp + "" + ")");
                    notifications.setBackgroundColor(Color.RED);
                    notifications.setTextColor(Color.WHITE);

                    for(int i=0;i<temp;i++) {
                        String s1[] = s[i + 1].toString().split("\\$");

                        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getContext()).setSmallIcon(R.drawable.ic_action_name).setContentTitle(s1[0]).setContentInfo(s1[1]).setContentText(s1[2]);

                        notificationManager.notify(i, notificationBuilder.build());
                    }

                }

            }
        });
        backgroundTask.execute(admin_view.getUser_id().trim());


        return v;

    }

}
