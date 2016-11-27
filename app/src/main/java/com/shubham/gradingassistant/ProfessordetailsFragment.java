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

import com.shubham.DAO.ProfessordetailsFragmentBackgroundTask;
import com.shubham.DAO.StudentdetailsFragmentBackgroundTask;


public class ProfessordetailsFragment extends Fragment {

    EditText ProfID;
    EditText  ProfName;
    EditText  ProfEmailID;
    EditText  course1;
    EditText  course2;
    EditText  course3;
    Button searchbutton;
    String s[];


    public ProfessordetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Toast.makeText(this.getContext(),"Message",Toast.LENGTH_SHORT).show();
        View v=  inflater.inflate(R.layout.activity_professordetails, container, false);



        ProfID=(EditText)v.findViewById(R.id.Professordetails_ProfessorID);
        ProfEmailID=(EditText)v.findViewById(R.id.Professordetails_emailID);
        ProfName=(EditText)v.findViewById(R.id.Professordetails_name);
        course1=(EditText)v.findViewById(R.id.Professordetails_course1);
        course2=(EditText)v.findViewById(R.id.Professordetails_course2);
        course3=(EditText)v.findViewById(R.id.Professordetails_course3);
        searchbutton=(Button)v.findViewById(R.id.Professordetails_search);

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pid=ProfID.getText().toString();

                ProfessordetailsFragmentBackgroundTask backgroundTask=new ProfessordetailsFragmentBackgroundTask(getContext(), new ProfessordetailsFragmentBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        // Toast.makeText(getContext(),userId,Toast.LENGTH_SHORT).show();
                        s=output.split("#");
                        ProfName.setText(s[0]);
                        ProfEmailID.setText(s[1]);
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
                backgroundTask.execute(pid);


            }
        });



        return v;

    }

}
