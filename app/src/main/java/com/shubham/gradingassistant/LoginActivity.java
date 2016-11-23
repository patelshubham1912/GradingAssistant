package com.shubham.gradingassistant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shubham.dao.DAO;

/**
 * Created by $hubham on 29/09/2016.
 */
public class LoginActivity extends Activity{
    Context ctx=this;
    Button login_button;
    EditText user_id;
    EditText password;
    String user;
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
//                String method = "Login";
//
//                BackgroundTask backgroundTask=new BackgroundTask(ctx);
//                backgroundTask.execute(u,p);
                DAO dao=new DAO();
                user=dao.getUser(u,p);
                Toast.makeText(getBaseContext(),user,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getBaseContext() ,MainActivity.class);
                intent.putExtra("User_type", user);
                startActivity(intent);

               // String s = getIntent().getStringExtra("EXTRA_SESSION_ID");-----in Receiving Activity
            }
        });

    }

}
