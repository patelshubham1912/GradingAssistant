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
import com.shubham.Beans.*;
import com.shubham.DAO.ChangepasswordFragmentBackgroundTask;
import com.shubham.DAO.LoginActivityBackgroundTask;


public class ChangepasswordFragment extends Fragment {
    EditText editTextoldpass;
    EditText editTextnewpass;
    EditText editTextconfirmpass;
    Button confirmbutton;
    admin_view admin_view=new admin_view();
    public ChangepasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_changepassword, container, false);

        editTextoldpass=(EditText)v.findViewById(R.id.changepassword_oldpassword);

        editTextnewpass=(EditText) v.findViewById(R.id.changepassword_newpass);

        editTextconfirmpass=(EditText) v.findViewById(R.id.changepassword_confirmpass);

        confirmbutton=(Button) v.findViewById(R.id.changepassword_confirmbutton);

       confirmbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String o=editTextoldpass.getText().toString();
               String n=editTextnewpass.getText().toString();
               String c=editTextconfirmpass.getText().toString();
               String uid="abc";

               if(n.equals(c)){


                   ChangepasswordFragmentBackgroundTask backgroundTask=new ChangepasswordFragmentBackgroundTask(getContext(), new ChangepasswordFragmentBackgroundTask.AsyncResponse() {
                       @Override
                       public void processFinish(String output) {
                           //admin_view=output;
                           Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
                          // Intent intent=new Intent(getContext() ,MainActivity.class);
                           //intent.putExtra("admin_view", output);
                          // startActivity(intent);
                       }
                   });
                   backgroundTask.execute(uid,n);

               }
               else {

                   Toast.makeText(getContext(),"Password does not match",Toast.LENGTH_SHORT).show();
               }
           }
       });

















        return v;

            }

}
