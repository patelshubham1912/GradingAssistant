package com.shubham.gradingassistant;


import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shubham.DAO.viewProjectsFragmentBackgroundTask;


public class viewProjectsFragment extends Fragment {
    RelativeLayout relativeLayout;
    String s[];
    public viewProjectsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View v=  inflater.inflate(R.layout.activity_viewprojects, container, false);
        //   relativeLayout=(RelativeLayout)v.findViewById(R.id.viewAssignment_RelativeLayout);

        final String courseId="C001";

        viewProjectsFragmentBackgroundTask backgroundTask = new viewProjectsFragmentBackgroundTask(getContext(), new viewProjectsFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                relativeLayout=(RelativeLayout)v.findViewById(R.id.viewProjects_RelativeLayout);
                int temp=0;
                s=output.split("#");
                try {
                    temp = Integer.parseInt(s[0].replaceAll("[\\D]", ""));
                    temp--;
                }
                catch (NumberFormatException e){}
                for(int i=0;i<=temp;i++)
                {
                    Button button=new Button(v.getContext());
                    button.setText(s[i+1]);
                    button.setId(v.generateViewId());
                    RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(20,i*100,20,0);
                    relativeLayout.addView(button,params);
                }
                //courseDescription.setText(output);
                Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
            }
        });
        backgroundTask.execute(courseId);
        return v;

    }

}
