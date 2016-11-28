package com.shubham.gradingassistant;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.Beans.course;
import com.shubham.DAO.RegisterForDegeePlanFragmentBackgroundTask;
/**
 * Created by neha_shet on 11/28/2016.
 */


public class RegisterForDegreePlanFragment extends Fragment {

    TextView register_for_degree_specialization;
    TextView register_for_degree_major;

    Button register_degree_plan_register;

    Spinner spinner1, spinner2;

    com.shubham.Beans.course course = new course();
    public RegisterForDegreePlanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.activity_registerfordegreeplan, container, false);

        register_for_degree_specialization = (TextView) v.findViewById(R.id.register_for_degree_specialization);
        register_for_degree_major = (TextView) v.findViewById(R.id.register_for_degree_major);
        spinner1 = (Spinner) v.findViewById(R.id.register_for_degree_major_spinner);
        spinner2 = (Spinner) v.findViewById(R.id.register_for_degree_specialization_spinner);
        register_degree_plan_register = (Button) v.findViewById(R.id.register_for_degree_register);

        register_degree_plan_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String specialization_type = spinner1.getSelectedItem().toString();
                String major_type = spinner2.getSelectedItem().toString();
                //String user_id = spinner2.getSelectedItem().toString();
                RegisterForDegeePlanFragmentBackgroundTask backgroundTask = new RegisterForDegeePlanFragmentBackgroundTask(getContext(), new RegisterForDegeePlanFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getContext(), output, Toast.LENGTH_SHORT).show();

                    }
                });

                SessionManager sessionManger = new SessionManager(getContext());
                admin_view userData = sessionManger.getUserDetails();
                String user_id = userData.getUser_id();
                //Toast.makeText(getContext(),user_id,Toast.LENGTH_SHORT).show();
                backgroundTask.execute(specialization_type, major_type, user_id );
            }
        });
        return v;
    }
}
