package com.shubham.gradingassistant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.DeleteUserFragmentBackgroundTask;


public class DeleteuserFragment extends Fragment {
    EditText userIdEditText;
    EditText emailIdEditText;
    EditText userTypeEditText;
    EditText userNameEditText;
    Button searchButton;
    Button deleteButton;
    String s[];
    public DeleteuserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_deleteuser, container, false);

        userIdEditText=(EditText)v.findViewById(R.id.DeleteUserFragment_userId);
        userNameEditText=(EditText)v.findViewById(R.id.DeleteUserFragment_userName);
        emailIdEditText=(EditText)v.findViewById(R.id.DeleteUserFragment_emailId);
        userTypeEditText=(EditText)v.findViewById(R.id.DeleteUserFragment_userType);

        searchButton=(Button)v.findViewById(R.id.DeleteUserFragment_searchButton);

        deleteButton=(Button)v.findViewById(R.id.DeleteUserFragment_deleteButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String userId=userIdEditText.getText().toString();

                DeleteUserFragmentBackgroundTask backgroundTask=new DeleteUserFragmentBackgroundTask(getContext(), new DeleteUserFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                       // Toast.makeText(getContext(),userId,Toast.LENGTH_SHORT).show();
                        s=output.split("#");

                        userNameEditText.setText(s[0]);
                        emailIdEditText.setText(s[1]);
                        userTypeEditText.setText(s[2]);
                        Toast.makeText(getContext(),s[0],Toast.LENGTH_SHORT).show();
                       // Intent intent=new Intent(getContext() ,MainActivity.class);
                       // intent.putExtra("admin_view", output);
                        //startActivity(intent);
                        //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(userId,"select");
            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId=userIdEditText.getText().toString();
                String usertype=userTypeEditText.getText().toString();
                DeleteUserFragmentBackgroundTask backgroundTask=new DeleteUserFragmentBackgroundTask(getContext(), new DeleteUserFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        // Toast.makeText(getContext(),userId,Toast.LENGTH_SHORT).show();

                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
                        // Intent intent=new Intent(getContext() ,MainActivity.class);
                        // intent.putExtra("admin_view", output);
                        //startActivity(intent);
                        //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(userId,"delete",usertype);
            }
        });
        return v;
    }

}
