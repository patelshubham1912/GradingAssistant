package com.shubham.gradingassistant;
import com.shubham.Beans.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    admin_view admin_view=new admin_view();
    NavigationView navigationView=null;
    Toolbar toolbar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code for setting the fragment initially
//        FirstFragment fragment = new FirstFragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();

        Intent i=getIntent();
        admin_view=(admin_view)i.getSerializableExtra("admin_view");
        Toast.makeText(getBaseContext(),admin_view.getEmail_id(),Toast.LENGTH_SHORT).show();

        if(admin_view.getEmail_id().equals("abc"))
        {
            //Admin View
            menu.setGroupCheckable(R.id.Admin, true, true);
            menu.setGroupVisible(R.id.Admin, true);
            menu.setGroupCheckable(R.id.Student,false,false);
            menu.setGroupVisible(R.id.Student,false);
            menu.setGroupCheckable(R.id.Professor,false,false);
            menu.setGroupVisible(R.id.Professor,false);
        }
        else if(admin_view.getEmail_id().equals("xyz"))
        {
            //Student View
            menu.setGroupCheckable(R.id.Admin, false, false);
            menu.setGroupVisible(R.id.Admin, false);
            menu.setGroupCheckable(R.id.Student,true,true);
            menu.setGroupVisible(R.id.Student,true);
            menu.setGroupCheckable(R.id.Professor,false,false);
            menu.setGroupVisible(R.id.Professor,false);
        }else
        {
            //Professor View
            menu.setGroupCheckable(R.id.Admin, true, true);
            menu.setGroupVisible(R.id.Admin, true);
            menu.setGroupCheckable(R.id.Student,true,true);
            menu.setGroupVisible(R.id.Student,true);
            menu.setGroupCheckable(R.id.Professor,true,true);
            menu.setGroupVisible(R.id.Professor,true);
        }
    }

    @Override

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_second3) {
            // First Fragment
            FirstFragment fragment = new FirstFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        }
//        else if (id == R.id.nav_third3) {
//            // Second Fragment
//            SecondFragment fragment = new SecondFragment();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container,fragment);
//            fragmentTransaction.commit();
//        }
        else if (id == R.id.nav_changepassword) {
            // Second Fragment
            ChangepasswordFragment fragment = new ChangepasswordFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_createUser) {
            // Second Fragment
            CreateuserFragment fragment = new CreateuserFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_deleteuser) {
            // Second Fragment
            DeleteuserFragment fragment = new DeleteuserFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_edituser) {
            // Second Fragment
            EdituserFragment fragment = new EdituserFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_createcourse) {
            // Second Fragment
            CreatecourseFragment fragment = new CreatecourseFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_editcourse) {
            // Second Fragment
            EditcourseFragment fragment = new EditcourseFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_linkcourseandprofessor) {
            // Second Fragment
            LinkcourseandprofessorFragment fragment = new LinkcourseandprofessorFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_viewcourse) {
            // Second Fragment
            ViewcourseFragment fragment = new ViewcourseFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_studentdetails) {
            // Second Fragment
            StudentdetailsFragment fragment = new StudentdetailsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_professordetails) {
            // Second Fragment
            ProfessordetailsFragment fragment = new ProfessordetailsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_addslide) {
            // Second Fragment
            AddslidesFragment fragment = new AddslidesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_updategrades) {
            // Second Fragment
            UpdategradeFragment fragment = new UpdategradeFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_sendquery) {
            // Second Fragment
            SendqueryFragment fragment = new SendqueryFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nav_registerForCourses) {
            // Second Fragment
            RegistercourseFragment fragment = new RegistercourseFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }else if(id==R.id.nav_viewcourseDescription)
        {
            viewCourseDescriptionFragment fragment = new viewCourseDescriptionFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_classActivityResult)
        {
            classActivityResultFragment fragment = new classActivityResultFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_avggpa)
        {
            avggpaFragment fragment = new avggpaFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_viewAssignment)
        {
            viewAssignmentFragment fragment = new viewAssignmentFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_viewSlides)
        {
            viewslidesFragment fragment = new viewslidesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_viewProjects)
        {
            viewProjectsFragment fragment = new viewProjectsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_viewQuizzes)
        {
            viewQuizzesFragment fragment = new viewQuizzesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }
        else if(id==R.id.nav_viewgrades)
        {
            viewgradesFragment fragment = new viewgradesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
