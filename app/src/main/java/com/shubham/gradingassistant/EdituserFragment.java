package com.shubham.gradingassistant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.EdituserFragmentBackgroundTask;



public class EdituserFragment extends Fragment {

    EditText edittext,edituser_type;
    EditText edituser_email;
    EditText edituser_username;
    Button button1,button2,edituser_cancel;
    admin_view admin_view;
    public EdituserFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_edituser, container, false);
        edittext=(EditText)v.findViewById(R.id.editUser_searchUser);
        edituser_email=(EditText)v.findViewById(R.id.edituser_email);
        edituser_type=(EditText)v.findViewById(R.id.edituser_userType);
        edituser_username=(EditText)v.findViewById(R.id.edituser_username);
        button1 = (Button) v.findViewById(R.id.editUser_Search);
        Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = edittext.getText().toString();

                EdituserFragmentBackgroundTask backgroundTask=new EdituserFragmentBackgroundTask(getContext(), new EdituserFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        //admin_view=output;
                        //edituser_email
                        String[] str = output.split("#");
                        if(str[0].trim().equals("error")) {

                            Toast.makeText(getContext(),"No user Found",Toast.LENGTH_SHORT).show();
                        } else {

                            edituser_email.setText(str[3]);
                            edituser_username.setText(str[2]);
                            edituser_type.setText(str[1]);
                        }
                    }
                });

               backgroundTask.execute(user_id,"select");
            }
        });

        button2 = (Button) v.findViewById(R.id.edit_user);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = edituser_email.getText().toString();
                String username = edituser_username.getText().toString();

                Toast.makeText(getContext(),email_id,Toast.LENGTH_SHORT).show();
                EdituserFragmentBackgroundTask backgroundTask=new EdituserFragmentBackgroundTask(getContext(), new EdituserFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getContext(),output,Toast.LENGTH_LONG).show();

                    }
                });
                backgroundTask.execute(edittext.getText().toString(),email_id,username,"update",edituser_type.getText().toString());
                //Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        edituser_cancel = (Button) v.findViewById(R.id.edituser_cancel);
        edituser_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edittext.setText("");
                edituser_email.setText("");
                edituser_username.setText("");
                edituser_type.setText("");
            }
        });
        //    Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();

        return v;
    }

}
