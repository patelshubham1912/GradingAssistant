package com.shubham.DAO;

import com.shubham.Beans.*;
import com.shubham.gradingassistant.*;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.shubham.gradingassistant.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by $hubham on 13/10/2016.
 */
public class CreateuserFragmentBackgroundTask extends AsyncTask<Void,Void,String> {
    private admin_view adminView;

    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;
    Context ctx;
    //admin_view admin_view=new admin_view();
    public CreateuserFragmentBackgroundTask(Context ctx,admin_view admin_view,AsyncResponse delegate) {
        this.ctx=ctx;
        this.delegate=delegate;
        this.adminView = admin_view;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void ... params) {


        String login_url = "http://"+ctx.getString(R.string.ip_address)+"/android_connect/CreateUser.php";
        try {
            URL url=new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS =httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("user_id","UTF-8")+"="+URLEncoder.encode(adminView.getUser_id(),"UTF-8")+"&"
                    +URLEncoder.encode("user_type","UTF-8")+"="+URLEncoder.encode(adminView.getUser_type(),"UTF-8")+"&"
                    +URLEncoder.encode("email_id","UTF-8")+"="+URLEncoder.encode(adminView.getEmail_id(),"UTF-8")+"&"
                    +URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(adminView.getUser_name(),"UTF-8")+"&"
                    +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode("","UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();

            InputStream IS = httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));
            String response="";
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {

                response+=line;
            }
            //admin_view.setEmail_id(response);
            bufferedReader.close();
            IS.close();
            httpURLConnection.disconnect();
            return response;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
       // Toast.makeText(ctx,result.getEmail_id(),Toast.LENGTH_SHORT).show();
        //setValues(result);
        delegate.processFinish(result);
        // LoginActivity loginActivity=new LoginActivity();
        // loginActivity.setReturnResult(result);
    }


}
