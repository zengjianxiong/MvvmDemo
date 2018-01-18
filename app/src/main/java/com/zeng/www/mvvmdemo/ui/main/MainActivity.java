package com.zeng.www.mvvmdemo.ui.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
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

import com.zeng.www.mvvmdemo.BR;
import com.zeng.www.mvvmdemo.BuildConfig;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.databinding.ActivityMainBinding;
import com.zeng.www.mvvmdemo.databinding.NavHeaderMainBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements NavigationView.OnNavigationItemSelectedListener, MainNavigator {

    @Inject
    MainViewModel mMainViewModel;

    ActivityMainBinding mActivityMainBinding;

    private DrawerLayout mDrawerLayout;

    private NavigationView mNavigationView;

    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = getViewDataBinding();
        mMainViewModel.setNavigator(this);

        setUp();


    }

    private void setUp() {
        mDrawerLayout = mActivityMainBinding.drawerLayout;
        mNavigationView = mActivityMainBinding.navView;
        mToolbar = mActivityMainBinding.toolbar;
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.string_open,
                R.string.string_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setupNavMenu();
        String version = String.format(getString(R.string.string_version), BuildConfig.VERSION_NAME);
        mMainViewModel.setAppVersion(version);
    }

    private void setupNavMenu() {

        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(
                getLayoutInflater(), R.layout.nav_header_main, mNavigationView, false);
        navHeaderMainBinding.setViewModel(mMainViewModel);
    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected MainViewModel getViewModel() {
        return mMainViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
