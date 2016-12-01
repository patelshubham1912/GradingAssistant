package com.shubham.gradingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shubham.Beans.course;
import com.shubham.DAO.UpdategradeFragmentBackgroundTask;


public class UpdategradeFragment extends Fragment {
    EditText studentIdText;
    EditText courseIdText;
    EditText assignmentText;
    EditText projectText;
    EditText midTermText;
    EditText finalText;
    EditText quiz;
    Button searchButton;
    Button updateButton;
    String s[];
    public UpdategradeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.activity_updategrades, container, false);

        studentIdText = (EditText)v.findViewById(R.id.updateGrades_StudentId);
        courseIdText=(EditText)v.findViewById(R.id.updateGrades_CourseId);
        assignmentText=(EditText)v.findViewById(R.id.updateGrades_Assignment);
        projectText=(EditText)v.findViewById(R.id.updateGrades_Project);
        midTermText=(EditText)v.findViewById(R.id.updateGrades_MidTerm);
        finalText=(EditText)v.findViewById(R.id.updateGrades_Final);
        quiz=(EditText)v.findViewById(R.id.updateGrades_Quiz);
        SessionManager sessionManger = new SessionManager(getContext());
        course course = sessionManger.getCourse();
        final String courseId=course.getCourse_id().trim();
        courseIdText.setText(courseId);
        searchButton=(Button)v.findViewById(R.id.UpdateGrades_search);

        updateButton=(Button)v.findViewById(R.id.UpdateGrades_update);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studId=studentIdText.getText().toString();
                String courseId=courseIdText.getText().toString();

                UpdategradeFragmentBackgroundTask backgroundTask=new UpdategradeFragmentBackgroundTask(getContext(), new UpdategradeFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        // Toast.makeText(getContext(),userId,Toast.LENGTH_SHORT).show();
                        s=output.split("#");

                        assignmentText.setText(s[0]);
                        projectText.setText(s[1]);
                        midTermText.setText(s[2]);
                        finalText.setText(s[3]);
                        quiz.setText(s[4]);
                        Toast.makeText(getContext(),s[0],Toast.LENGTH_SHORT).show();
                        // Intent intent=new Intent(getContext() ,MainActivity.class);
                        // intent.putExtra("admin_view", output);
                        //startActivity(intent);
                        //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(studId,courseId,"select");
            }
        });


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studId=studentIdText.getText().toString();
                String courseId=courseIdText.getText().toString();
                String assignment=assignmentText.getText().toString();
                String project=projectText.getText().toString();
                String midTerm=midTermText.getText().toString();
                String finalText1=finalText.getText().toString();
                String quiz1=quiz.getText().toString();
                UpdategradeFragmentBackgroundTask backgroundTask=new UpdategradeFragmentBackgroundTask(getContext(), new UpdategradeFragmentBackgroundTask.AsyncResponse() {
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
                backgroundTask.execute(studId,courseId,"update",assignment,project,midTerm,finalText1,quiz1);
            }
        });
        return v;

    }

}
