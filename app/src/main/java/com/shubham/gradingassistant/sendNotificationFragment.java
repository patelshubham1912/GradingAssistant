package com.shubham.gradingassistant;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.sendNotificationFragmentBackgroundTask;


public class sendNotificationFragment extends Fragment {
    EditText toText;
    EditText subjectText;
    EditText messageText;
    Button sendButton;

    public sendNotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Toast.makeText(this.getContext(),"Message",Toast.LENGTH_SHORT).show();
        View v=  inflater.inflate(R.layout.activity_sendnotification, container, false);
        toText = (EditText)v.findViewById(R.id.sendNotification_to);
        subjectText = (EditText)v.findViewById(R.id.sendNotification_subject);
        messageText = (EditText)v.findViewById(R.id.sendNotification_message);
        sendButton =(Button)v.findViewById(R.id.sendNotification_send);
        SessionManager sessionManger = new SessionManager(getContext());
        final admin_view admin_view=sessionManger.getUserDetails();
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sender=admin_view.getUser_id().trim();
                String to=toText.getText().toString();
                String subject=subjectText.getText().toString();
                String message=messageText.getText().toString();


                sendNotificationFragmentBackgroundTask backgroundTask = new sendNotificationFragmentBackgroundTask(getContext(), new sendNotificationFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();

                    }
                });
                backgroundTask.execute(sender,to,subject,message);
            }
        });

        return v;

    }

}
