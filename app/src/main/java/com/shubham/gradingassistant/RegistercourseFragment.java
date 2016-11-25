package com.shubham.gradingassistant;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.shubham.DAO.RegistercourseFragmentBackgroundTask;


public class RegistercourseFragment extends Fragment {
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Button registerButton;
    public RegistercourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Toast.makeText(this.getContext(),"Message",Toast.LENGTH_SHORT).show();
        View v=  inflater.inflate(R.layout.activity_registercourse, container, false);
        spinner1 = (Spinner)v.findViewById(R.id.registercourse_spinner);
        spinner2 = (Spinner)v.findViewById(R.id.registercourse_spinner2);
        spinner3 = (Spinner)v.findViewById(R.id.registercourse_spinner3);
        registerButton =(Button)v.findViewById(R.id.registercourse_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinner1text=spinner1.getSelectedItem().toString();
                String spinner2text=spinner2.getSelectedItem().toString();
                String spinner3text=spinner3.getSelectedItem().toString();
                String userid="abc";
                RegistercourseFragmentBackgroundTask backgroundTask = new RegistercourseFragmentBackgroundTask(getContext(), new RegistercourseFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();

                    }
                });
                backgroundTask.execute(spinner1text,spinner2text,spinner3text,userid);
            }
        });


        return v;

    }

}
