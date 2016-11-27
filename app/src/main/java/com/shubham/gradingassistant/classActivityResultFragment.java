package com.shubham.gradingassistant;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.DAO.classActivityResultFragmentBackgroundTask;


public class classActivityResultFragment extends Fragment {
RelativeLayout relativeLayout;
    String s[];

    public classActivityResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View v=  inflater.inflate(R.layout.activity_viewclassactivityresult, container, false);

        final String courseId="C001";

        classActivityResultFragmentBackgroundTask backgroundTask = new classActivityResultFragmentBackgroundTask(getContext(), new classActivityResultFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                relativeLayout=(RelativeLayout)v.findViewById(R.id.viewClassActivityResult_RelativeLayout);
                int temp=0;
                s=output.split("#");
                try {
                    temp = Integer.parseInt(s[0].replaceAll("[\\D]", ""));
                    temp--;
                }
                catch (NumberFormatException e){}

                for(int i=0;i<=temp;i++)
                {
                    String s1[]=s[i+1].toString().split("\\$");
                    TextView title=new TextView(v.getContext());
                    title.setText(s1[0]);
                    title.setId(v.generateViewId());
                    title.setTypeface(null, Typeface.BOLD);
                    title.setTextSize(TypedValue.COMPLEX_UNIT_PX,40);
                    RelativeLayout.LayoutParams titleparams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    titleparams.setMargins(20,i*300,20,0);
                    relativeLayout.addView(title,titleparams);

                    TextView textView=new TextView(v.getContext());
                    textView.setText("Mean: "+s1[1]+"\nMedian: "+s1[2]+"\nStandard Deviation: "+s1[3]+"\nHighest Score: "+s1[4]+"\nLowest Score: "+s1[5]);
                    textView.setSingleLine(false);
                    textView.setId(v.generateViewId());
                    RelativeLayout.LayoutParams textViewparams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    textViewparams.setMargins(20,i*300+50,20,0);
                    relativeLayout.addView(textView,textViewparams);
                }
                //courseDescription.setText(output);
                Toast.makeText(getContext(),output+"",Toast.LENGTH_SHORT).show();
            }
        });
        backgroundTask.execute(courseId);

        return v;

    }

}
