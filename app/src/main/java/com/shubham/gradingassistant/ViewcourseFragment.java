package com.shubham.gradingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shubham.Beans.admin_view;
import com.shubham.DAO.ViewCourseBackgroundTask;


public class ViewcourseFragment extends Fragment {


    EditText viewCourse_courseID;
    EditText viewCourse_coursename;
    EditText viewCourse_professor;
    EditText viewCourse_majortype;
    Button viewCourse_search;
    String coursedetails[];

    public ViewcourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.activity_viewcourse, container, false);
        viewCourse_courseID = (EditText) v.findViewById(R.id.viewCourse_courseID);
        viewCourse_coursename = (EditText) v.findViewById(R.id.viewCourse_coursename);
        viewCourse_professor = (EditText) v.findViewById(R.id.viewCourse_professor);
        viewCourse_majortype = (EditText) v.findViewById(R.id.viewCourse_majortype);
        viewCourse_search = (Button) v.findViewById(R.id.viewCourse_search);
        viewCourse_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String courseID = viewCourse_courseID.getText().toString();
                Toast.makeText(getContext(),courseID,Toast.LENGTH_SHORT).show();
                ViewCourseBackgroundTask backgroundTask=new ViewCourseBackgroundTask(getContext(), new ViewCourseBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {


                         coursedetails = output.split("#");
                        viewCourse_courseID.setText(coursedetails[0]);
                        viewCourse_coursename.setText(coursedetails[1]);
                        viewCourse_professor.setText(coursedetails[2]);
                        viewCourse_majortype.setText(coursedetails[2]);

                     //   admin_view=output;

                        Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
                        // Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                        // intent.putExtra("admin_view", output);
                        // startActivity(intent);
                        //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(courseID);
                //Toast.makeText(getContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });


        return v;

    }

}
