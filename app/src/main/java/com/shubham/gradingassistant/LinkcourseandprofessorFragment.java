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
import android.widget.Toast;

import com.shubham.DAO.LinkcourseandprofessorFragmentBackgroundTask;


public class LinkcourseandprofessorFragment extends Fragment {
    EditText courseIdEditText;
    EditText professorIdEditText;
    private Button linkButton;

    public LinkcourseandprofessorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_linkcourseandprofessor, container, false);
        courseIdEditText = (EditText)v.findViewById(R.id.linkcourseandprofessor_courseId);
        professorIdEditText = (EditText)v.findViewById(R.id.linkcourseandprofessor_professorId);
        linkButton = (Button)v.findViewById(R.id.linkcourseandprofessor_linkButton);

        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseId=courseIdEditText.getText().toString();
                String professorId=professorIdEditText.getText().toString();
                LinkcourseandprofessorFragmentBackgroundTask backgroundTask=new LinkcourseandprofessorFragmentBackgroundTask(getContext(), new LinkcourseandprofessorFragmentBackgroundTask.AsyncResponse() {
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
                backgroundTask.execute(courseId,professorId);
            }
        });

        return v;

    }

}
