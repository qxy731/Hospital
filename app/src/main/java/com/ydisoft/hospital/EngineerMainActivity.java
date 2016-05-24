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

public class EngineerMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.engineer_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.engineer_toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.engineer_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系客服", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.engineer_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.engineer_navigation);
        navigationView.setNavigationItemSelectedListener(this);

        initContentLayout(Constants.ROLE_ENGINEER,"include201");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.engineer_drawer_layout);
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
        if (id == R.id.engineer_repair_order) {
            initContentLayout(Constants.ROLE_ENGINEER,"include201");
        } else if (id == R.id.engineer_release_technical) {
            initContentLayout(Constants.ROLE_ENGINEER,"include202");
        } else if (id == R.id.engineer_coordination_needs) {
            initContentLayout(Constants.ROLE_ENGINEER,"include203");
        } else if (id == R.id.engineer_resource_sharing) {
            initContentLayout(Constants.ROLE_ENGINEER,"include204");
        } else if (id == R.id.engineer_resource_search) {
            initContentLayout(Constants.ROLE_ENGINEER,"include205");
        } else if (id == R.id.engineer_my_information) {
            initContentLayout(Constants.ROLE_ENGINEER,"include206");
        }else if (id == R.id.engineer_my_order) {
            initContentLayout(Constants.ROLE_ENGINEER,"include207");
        }else if (id == R.id.engineer_my_coordination) {
            initContentLayout(Constants.ROLE_ENGINEER,"include208");
        }else if (id == R.id.engineer_my_resource) {
            initContentLayout(Constants.ROLE_ENGINEER,"include209");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.engineer_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void initContentLayout(String role,String includeIdName){
        RelativeLayout layout200 = (RelativeLayout) findViewById(R.id.include200);
        RelativeLayout layout201 = (RelativeLayout) findViewById(R.id.include201);
        RelativeLayout layout202 = (RelativeLayout) findViewById(R.id.include202);
        RelativeLayout layout203 = (RelativeLayout) findViewById(R.id.include203);
        RelativeLayout layout204 = (RelativeLayout) findViewById(R.id.include204);
        RelativeLayout layout205 = (RelativeLayout) findViewById(R.id.include205);
        RelativeLayout layout206 = (RelativeLayout) findViewById(R.id.include206);
        RelativeLayout layout207 = (RelativeLayout) findViewById(R.id.include207);
        RelativeLayout layout208 = (RelativeLayout) findViewById(R.id.include208);
        RelativeLayout layout209 = (RelativeLayout) findViewById(R.id.include209);
        if ("include200".equals(includeIdName)) {
            layout200.setVisibility(View.VISIBLE);
        } else {
            layout200.setVisibility(View.GONE);
        }
        if ("include201".equals(includeIdName)) {
            layout201.setVisibility(View.VISIBLE);
        } else {
            layout201.setVisibility(View.GONE);
        }
        if ("include202".equals(includeIdName)) {
            layout202.setVisibility(View.VISIBLE);
        } else {
            layout202.setVisibility(View.GONE);
        }
        if ("include203".equals(includeIdName)) {
            layout203.setVisibility(View.VISIBLE);
        } else {
            layout203.setVisibility(View.GONE);
        }
        if ("include204".equals(includeIdName)) {
            layout204.setVisibility(View.VISIBLE);
        } else {
            layout204.setVisibility(View.GONE);
        }
        if ("include205".equals(includeIdName)) {
            layout205.setVisibility(View.VISIBLE);
        } else {
            layout205.setVisibility(View.GONE);
        }
        if ("include206".equals(includeIdName)) {
            layout206.setVisibility(View.VISIBLE);
        } else {
            layout206.setVisibility(View.GONE);
        }
        if ("include207".equals(includeIdName)) {
            layout207.setVisibility(View.VISIBLE);
        } else {
            layout207.setVisibility(View.GONE);
        }
        if ("include208".equals(includeIdName)) {
            layout208.setVisibility(View.VISIBLE);
        } else {
            layout208.setVisibility(View.GONE);
        }
        if ("include209".equals(includeIdName)) {
            layout209.setVisibility(View.VISIBLE);
        } else {
            layout209.setVisibility(View.GONE);
        }
    }
}
