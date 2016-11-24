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
import com.shubham.DAO.LoginActivityBackgroundTask;



public class EdituserFragment extends Fragment {

    EditText edittext;
    Button button1;
    admin_view admin_view;
    public EdituserFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toast.makeText(getActivity().getBaseContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity().getBaseContext(),"Welcome",Toast.LENGTH_SHORT).show();

        View v = inflater.inflate(R.layout.activity_edituser, container, false);
        edittext=(EditText)v.findViewById(R.id.editUser_searchUser);
        button1 = (Button) v.findViewById(R.id.editUser_Search);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivityBackgroundTask backgroundTask=new LoginActivityBackgroundTask(getContext(), new LoginActivityBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(admin_view output) {

                        admin_view=output;
                        Toast.makeText(getContext(),admin_view.getEmail_id(),Toast.LENGTH_SHORT).show();
                        
                       // Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                       // intent.putExtra("admin_view", output);
                       // startActivity(intent);
                        //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute("abc","abc");
                //Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    //    Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();

        return v;
    }

}
