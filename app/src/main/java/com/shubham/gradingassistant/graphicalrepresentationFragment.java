package com.shubham.gradingassistant;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;
import com.shubham.DAO.classActivityResultFragmentBackgroundTask;


public class graphicalrepresentationFragment extends Fragment {
GraphView graphView;
    String s[];
    Float mean[];
    Float median[];
    Float sd[];
    Float hs[];
    Float ls[];
    DataPoint dp_mean[],dp_median[],dp_sd[],dp_hs[],dp_ls[];
    String type[];
    public graphicalrepresentationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v=  inflater.inflate(R.layout.activity_graphicalrepresentation, container, false);
        String courseId="C001";
        classActivityResultFragmentBackgroundTask backgroundTask = new classActivityResultFragmentBackgroundTask(getContext(), new classActivityResultFragmentBackgroundTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {

                int temp=0;
                s=output.split("#");
                try {
                    temp = Integer.parseInt(s[0].replaceAll("[\\D]", ""));
                    temp--;
                }
                catch (NumberFormatException e){}
                type=new String[temp+1];
                mean=new Float[temp+1];
                median=new Float[temp+1];
                sd=new Float[temp+1];
                hs=new Float[temp+1];
                ls=new Float[temp+1];
                for(int i=0;i<=temp;i++)
                {
                    String s1[]=s[i+1].split("\\$");
                    type[i]=s1[0].replaceAll("\\s","");
                    mean[i]=Float.parseFloat(s1[1].replaceAll("\\s",""));
                    median[i]=Float.parseFloat(s1[2].replaceAll("\\s",""));
                    sd[i]=Float.parseFloat(s1[3].replaceAll("\\s",""));
                    hs[i]=Float.parseFloat(s1[4].replaceAll("\\s",""));
                    ls[i]=Float.parseFloat(s1[5].replaceAll("\\s",""));

                }

                graphView=(GraphView)v.findViewById(R.id.graphicalrepresentation_graph);
                dp_mean=new DataPoint[temp+1];
                dp_median=new DataPoint[temp+1];
                dp_sd=new DataPoint[temp+1];
                dp_hs=new DataPoint[temp+1];
                dp_ls=new DataPoint[temp+1];

                for(int i=0;i<=temp;i++)
                {
                    dp_mean[i]=new DataPoint(i*2,mean[i]);
                    dp_median[i]=new DataPoint(i*2,median[i]);
                    dp_sd[i]=new DataPoint(i*2,sd[i]);
                    dp_hs[i]=new DataPoint(i*2,hs[i]);
                    dp_ls[i]=new DataPoint(i*2,ls[i]);
                }
                LineGraphSeries<DataPoint> mean_line_series = new LineGraphSeries<DataPoint>(dp_mean);
                LineGraphSeries<DataPoint> median_line_series = new LineGraphSeries<DataPoint>(dp_median);
                LineGraphSeries<DataPoint> sd_line_series = new LineGraphSeries<DataPoint>(dp_sd);
                LineGraphSeries<DataPoint> hs_line_series = new LineGraphSeries<DataPoint>(dp_hs);
                LineGraphSeries<DataPoint> ls_line_series = new LineGraphSeries<DataPoint>(dp_ls);
                mean_line_series.setColor(Color.BLUE);
                median_line_series.setColor(Color.GREEN);
                sd_line_series.setColor(Color.RED);
                hs_line_series.setColor(Color.YELLOW);
                ls_line_series.setColor(Color.CYAN);

                graphView.addSeries(mean_line_series);
                graphView.addSeries(median_line_series);
                graphView.addSeries(sd_line_series);
                graphView.addSeries(hs_line_series);
                graphView.addSeries(ls_line_series);




                StaticLabelsFormatter staticLabelsFormatter=new StaticLabelsFormatter(graphView);
                graphView.setTitleTextSize(10);
                staticLabelsFormatter.setHorizontalLabels(type);
                graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                graphView.getViewport().setYAxisBoundsManual(true);
                graphView.getViewport().setMinY(0);
                graphView.getViewport().setMaxY(100);

            }
        });
        backgroundTask.execute(courseId);




        return v;
    }


}
