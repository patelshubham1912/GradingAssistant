package com.shubham.gradingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.shubham.DAO.EditCourseBackgroundTask;


public class EditcourseFragment extends Fragment {

    EditText courseid;
    EditText coursename;
    EditText prereq1;
    EditText Studentsnumber;
    EditText credithour;
    Button search;
    Button edit;

    Spinner specializationtype, degreetype;
    String s[];

    public EditcourseFragment() {
        // Required empty public constructor
            }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=  inflater.inflate(R.layout.activity_editcourse, container, false);

        courseid = (EditText) v.findViewById(R.id.courseid);
        coursename = (EditText)v.findViewById(R.id.edcoursename);
        prereq1 = (EditText)v.findViewById(R.id.prereq1);
        Studentsnumber = (EditText)v.findViewById(R.id.student);
        credithour = (EditText)v.findViewById(R.id.credit);
        search = (Button)v.findViewById(R.id.btsearch);
        edit = (Button)v.findViewById(R.id.btedit);
        specializationtype = (Spinner)v.findViewById(R.id.specialization);
        degreetype =(Spinner)v.findViewById(R.id.degreetype);

        // Inflate the layout for this fragment
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                String cid = courseid.getText().toString();
                String cn = coursename.getText().toString();
                String ns = Studentsnumber.getText().toString();
                String ch = credithour.getText().toString();
                String pre1 = prereq1.getText().toString();

                EditCourseBackgroundTask backgroundTask = new EditCourseBackgroundTask(getContext(), new EditCourseBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        s = output.split("#");
                        coursename.setText(s[0]);
                        prereq1.setText(s[5]);
                        Studentsnumber.setText(s[3]);
                        credithour.setText(s[4]);

                        specializationtype.setSelection(getIndex(specializationtype, s[1]));
                        degreetype.setSelection(getIndex(degreetype,s[2]));
                        //Toast.makeText(getContext(), output, Toast.LENGTH_SHORT).show();
                        }
                });
                        backgroundTask.execute(cid, "select");
                    }
                });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cn = coursename.getText().toString();
                String ns = Studentsnumber.getText().toString();
                String ch = credithour.getText().toString();
                String pre1 = prereq1.getText().toString();
                String courseId=courseid.getText().toString();
                String spclType = (String)specializationtype.getSelectedItem();
                String degreeType = (String)degreetype.getSelectedItem();

                EditCourseBackgroundTask backgroundTask=new EditCourseBackgroundTask(getContext(), new EditCourseBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {

                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(cn,"update",ns,ch,pre1,spclType,degreeType,courseId);
                    }
        });
                 return v;

        }

    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }
}




