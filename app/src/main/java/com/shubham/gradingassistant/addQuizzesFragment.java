package com.shubham.gradingassistant;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.Beans.course;
import com.shubham.DAO.*;

import java.io.File;


public class addQuizzesFragment extends Fragment {
    TextView fileName;
    Button  browse;
    Button upload;
    String courseId;

    public addQuizzesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=  inflater.inflate(R.layout.activity_addquiz, container, false);
        SessionManager sessionManger = new SessionManager(getContext());
        course course = sessionManger.getCourse();
        courseId=course.getCourse_id();
        browse=(Button)v.findViewById(R.id.addQuiz_browse);
        upload=(Button)v.findViewById(R.id.addQuiz_upload);
        fileName=(TextView)v.findViewById(R.id.addQuiz_filename);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int PICKFILE_RESULT_CODE = 1;
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, PICKFILE_RESULT_CODE);
            }
        });


        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == Activity.RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    String uriString = uri.toString();
                    File myFile = new File(uri.toString());
                    String path = myFile.getAbsolutePath();
                    String displayName = null;

                    if (uriString.startsWith("content://")) {
                        Cursor cursor = null;
                        try {
                            cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
                            if (cursor != null && cursor.moveToFirst()) {
                                displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                            }
                        } finally {
                            cursor.close();
                        }
                    } else if (uriString.startsWith("file://")) {
                        displayName = myFile.getName();

                    }
                    Toast.makeText(getContext(),displayName,Toast.LENGTH_SHORT).show();
                    fileName.setText(displayName);
                    upload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            addDocumentsBackgroundTask backgroundTask = new addDocumentsBackgroundTask(getContext(), new addDocumentsBackgroundTask.AsyncResponse() {
                                @Override
                                public void processFinish(String output) {

                                    Toast.makeText(getContext(),output,Toast.LENGTH_SHORT).show();
                                }
                            });
                            backgroundTask.execute(courseId,"quiz",fileName.getText().toString());
                        }
                    });
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
