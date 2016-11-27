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

import com.shubham.DAO.StudentdetailsFragmentBackgroundTask;


public class StudentdetailsFragment extends Fragment {

    EditText  studentID;
    EditText  Name;
    EditText  EmailID;
    EditText  course1;
    EditText  course2;
    EditText  course3;
    Button     search;
    String s[];
    public StudentdetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Toast.makeText(this.getContext(),"Message",Toast.LENGTH_SHORT).show();
        View v=  inflater.inflate(R.layout.activity_studentdetails, container, false);

        studentID=(EditText)v.findViewById(R.id.Studentdetail_StudentID);
        EmailID=(EditText)v.findViewById(R.id.Studentdetail_Email);
        Name=(EditText)v.findViewById(R.id.Studentdetail_Name);
        course1=(EditText)v.findViewById(R.id.Studentdetail_Course1);
        course2=(EditText)v.findViewById(R.id.Studentdetail_Course2);
        course3=(EditText)v.findViewById(R.id.Studentdetail_Course3);
        search=(Button)v.findViewById(R.id.Studentdetail_button);

        search.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        String sid=studentID.getText().toString();
        StudentdetailsFragmentBackgroundTask backgroundTask=new StudentdetailsFragmentBackgroundTask(getContext(), new StudentdetailsFragmentBackgroundTask.AsyncResponse() {
        @Override
         public void processFinish(String output) {
            // Toast.makeText(getContext(),userId,Toast.LENGTH_SHORT).show();
            s=output.split("#");
            Name.setText(s[0]);
            EmailID.setText(s[1]);
            course1.setText(s[2]);
            course2.setText(s[3]);
            course3.setText(s[4]);
            Toast.makeText(getContext(),s[0],Toast.LENGTH_SHORT).show();
            // Intent intent=new Intent(getContext() ,MainActivity.class);
            // intent.putExtra("admin_view", output);
            //startActivity(intent);
            //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
        }
        });
            backgroundTask.execute(sid);

        }
        });



        return v;

    }

}
