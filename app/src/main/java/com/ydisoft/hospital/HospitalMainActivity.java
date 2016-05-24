package com.ydisoft.hospital;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.ydisoft.hospital.util.Constants;

public class HospitalMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.hospital_toolbar);
        //toolbar.setTitle("");
        //toolbar.setSubtitle("");
        //toolbar.setLogo();
        //toolbar.setNavigationIcon();
        //toolbar.setNavigationOnClickListener();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.hospital_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系客服", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.hospital_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.hospital_navigation);
        navigationView.setNavigationItemSelectedListener(this);

        initContentLayout(Constants.ROLE_HOSPITAL,"include101");
    }

            @Override
            public void onBackPressed() {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.hospital_drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    super.onBackPressed();
                }
            }


            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();
                return super.onOptionsItemSelected(item);
            }

            @SuppressWarnings("StatementWithEmptyBody")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.hospital_device_repair) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include101");
                } else if (id == R.id.hospital_fittings_query) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include102");
                } else if (id == R.id.hospital_device_leasing) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include103");
                } else if (id == R.id.common_technical_advisory) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include104");
                } else if (id == R.id.hospital_my_information) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include105");
                } else if (id == R.id.hospital_my_device) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include106");
                }else if (id == R.id.hospital_my_repair) {
                    initContentLayout(Constants.ROLE_HOSPITAL,"include107");
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.hospital_drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            protected void initContentLayout(String role,String includeIdName){
                    RelativeLayout layout100 = (RelativeLayout) findViewById(R.id.include100);
                    RelativeLayout layout101 = (RelativeLayout) findViewById(R.id.include101);
                    RelativeLayout layout102 = (RelativeLayout) findViewById(R.id.include102);
                    RelativeLayout layout103 = (RelativeLayout) findViewById(R.id.include103);
                    RelativeLayout layout104 = (RelativeLayout) findViewById(R.id.include104);
                    RelativeLayout layout105 = (RelativeLayout) findViewById(R.id.include105);
                    RelativeLayout layout106 = (RelativeLayout) findViewById(R.id.include106);
                    RelativeLayout layout107 = (RelativeLayout) findViewById(R.id.include107);
                    if ("include100".equals(includeIdName)) {
                        layout100.setVisibility(View.VISIBLE);
                    } else {
                        layout100.setVisibility(View.GONE);
                    }
                    if ("include101".equals(includeIdName)) {
                        layout101.setVisibility(View.VISIBLE);
                    } else {
                        layout101.setVisibility(View.GONE);
                    }
                    if ("include102".equals(includeIdName)) {
                        layout102.setVisibility(View.VISIBLE);
                    } else {
                        layout102.setVisibility(View.GONE);
                    }
                    if ("include3".equals(includeIdName)) {
                        layout103.setVisibility(View.VISIBLE);
                    } else {
                        layout103.setVisibility(View.GONE);
                    }
                    if ("include104".equals(includeIdName)) {
                        layout104.setVisibility(View.VISIBLE);
                    } else {
                        layout104.setVisibility(View.GONE);
                    }
                    if ("include105".equals(includeIdName)) {
                        layout105.setVisibility(View.VISIBLE);
                    } else {
                        layout105.setVisibility(View.GONE);
                    }
                    if ("include106".equals(includeIdName)) {
                        layout106.setVisibility(View.VISIBLE);
                    } else {
                        layout106.setVisibility(View.GONE);
                    }
                    if ("include107".equals(includeIdName)) {
                        layout107.setVisibility(View.VISIBLE);
                    } else {
                        layout107.setVisibility(View.GONE);
                    }
            }



}

