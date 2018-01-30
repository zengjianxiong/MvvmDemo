package com.zeng.www.mvvmdemo.ui.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.zeng.www.mvvmdemo.BR;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.databinding.ActivityFeedBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class FeedActivity extends BaseActivity<ActivityFeedBinding, FeedViewModel> implements HasSupportFragmentInjector {


    @Inject
    FeedViewModel mFeedViewModel;

    @Inject
    FeedPagerAdapter mPagerAdapter;

    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

    ActivityFeedBinding mActivityFeedBinding;

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, FeedActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityFeedBinding = getViewDataBinding();

        setUp();
    }

    private void setUp() {
        setSupportActionBar(mActivityFeedBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mTabLayout = mActivityFeedBinding.tabLayout;
        mViewPager = mActivityFeedBinding.feedViewPager;
        mPagerAdapter.setTabCount(2);
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.blog)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.open_source)));

        mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                upIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {

                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                } else {
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected FeedViewModel getViewModel() {
        return mFeedViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feed;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingAndroidInjector;
    }
}
