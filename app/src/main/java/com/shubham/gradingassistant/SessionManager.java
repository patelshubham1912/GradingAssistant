package com.shubham.gradingassistant;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.shubham.Beans.admin_view;
import com.shubham.Beans.course;

/**
 * Created by neha_shet on 11/28/2016.
 */

public class SessionManager {

    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERID = "user_id";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERTYPE = "user_type";

    public static final String KEY_COURSE_ID = "course_id";
    public static final String KEY_COURSE_NAME = "course_email";
    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String user_id,String name, String email,String user_type){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_USERID, user_id);
        editor.putString(KEY_NAME, name);
        // Storing email in pref
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_USERTYPE, user_type);


        // commit changes
        editor.commit();
    }
    public admin_view getUserDetails() {

        admin_view user = new admin_view();
        user.setUser_id(pref.getString(KEY_USERID,null));
        user.setUser_name(pref.getString(KEY_NAME,null));
        user.setEmail_id(pref.getString(KEY_EMAIL,null));
        user.setUser_type(pref.getString(KEY_USERTYPE,null));
        return user;
    }

    //create course session
    public void createCourse(String course_id){

        // Storing course_id in pref
        editor.putString(KEY_COURSE_ID, course_id);

        // Storing email in pref
       // editor.putString(KEY_COURSE_NAME, course_name);

        // commit changes
        editor.commit();
    }
    public course getCourse(){

        // Storing course_id in pref
        course course = new course();
        course.setCourse_id(pref.getString(KEY_COURSE_ID,null));
        //course.setCourse_name(pref.getString(KEY_COURSE_NAME,null));
        return course;
    }


}
