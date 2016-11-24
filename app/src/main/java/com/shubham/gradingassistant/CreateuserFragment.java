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
import com.shubham.DAO.CreateuserFragmentBackgroundTask;
import com.shubham.DAO.LoginActivityBackgroundTask;


public class CreateuserFragment extends Fragment {

    EditText user_name;
    EditText user_id;
    Spinner user_type;
    EditText email_id;
    Button create_user;
    admin_view admin_view = new admin_view();
    public CreateuserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.activity_createuser, container, false);
        user_name = (EditText)v.findViewById(R.id.createuser_username);
        user_id = (EditText)v.findViewById(R.id.createuser_userid);
        email_id = (EditText)v.findViewById(R.id.createuser_email);
        //Spinner mySpinner=(Spinner) findViewById(R.id.your_spinner);

        user_type = (Spinner)v.findViewById(R.id.createuser_usertype);

        create_user = (Button) v.findViewById(R.id.createuser_create);
            create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                admin_view.setEmail_id(email_id.getText().toString());
                admin_view.setUser_name(user_name.getText().toString());
                admin_view.setUser_id(user_id.getText().toString());
                admin_view.setUser_type(user_type.getSelectedItem().toString());
                CreateuserFragmentBackgroundTask backgroundTask = new CreateuserFragmentBackgroundTask(getContext(),admin_view, new CreateuserFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        //admin_view = output;
                        Toast.makeText(getContext(),output, Toast.LENGTH_SHORT).show();
                        email_id.setText("");
                        user_name.setText("");
                        user_id.setText("");
                       user_type.setSelection(0);

                    }
                });
                backgroundTask.execute();
            }
        });

        return v;
    }

}
