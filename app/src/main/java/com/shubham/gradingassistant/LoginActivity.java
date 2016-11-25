package com.shubham.gradingassistant;
import com.shubham.Beans.*;
import com.shubham.DAO.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by $hubham on 29/09/2016.
 */
public class LoginActivity extends Activity{

    Context ctx=this;
    Button login_button;
    EditText user_id;
    EditText password;
    String user;
    admin_view admin_view=new admin_view();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = (Button)findViewById(R.id.button_login);
        user_id=(EditText)findViewById(R.id.user_id);
        password=(EditText)findViewById(R.id.password);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                String u=user_id.getText().toString();
                String p=password.getText().toString();
                //String method = "Login";

                LoginActivityBackgroundTask backgroundTask=new LoginActivityBackgroundTask(ctx, new LoginActivityBackgroundTask.AsyncResponse() {
                    @Override
                    public void processFinish(admin_view output) {

                        admin_view=output;
                        Toast.makeText(getBaseContext(),admin_view.getEmail_id(),Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                        intent.putExtra("admin_view", output);
                        startActivity(intent);
                        //Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();
                    }
                });
                backgroundTask.execute(u,p);


//              Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                //intent.putExtra("admin_view", output);
                //startActivity(intent);
               // Toast.makeText(getBaseContext(),admin_view,Toast.LENGTH_SHORT).show();


               // String s = getIntent().getStringExtra("EXTRA_SESSION_ID");-----in Receiving Activity
            }
        });

    }
    /*public void setReturnResult(admin_view result)
    {
        admin_view=result;
        Toast.makeText(getBaseContext(),result.getEmail_id(),Toast.LENGTH_SHORT).show();
    }*/
}
