package com.tehreh1uneh.geekbrains_material;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show());


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            setNewNavigationViewColors(R.color.colorAccent, R.color.colorError);
        } else if (id == R.id.nav_gallery) {
            setNewNavigationViewColors(R.color.colorTextSecondary, R.color.colorHint);
        } else if (id == R.id.nav_slideshow) {
            setNewNavigationViewColors(R.color.colorHighlight, R.color.colorActivatedHighlight);
        } else if (id == R.id.nav_manage) {
            setNewNavigationViewColors(R.color.colorError, R.color.colorHighlight);
        } else if (id == R.id.nav_share) {
            setNewNavigationViewColors(R.color.colorHint, R.color.colorAccent);
        } else if (id == R.id.nav_send) {
            setNewNavigationViewColors(R.color.colorText, R.color.colorActivatedHighlight);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void setNewNavigationViewColors(int textColor, int iconColor){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            navigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(textColor, getTheme())));
            navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(iconColor, getTheme())));
        }
    }

}
