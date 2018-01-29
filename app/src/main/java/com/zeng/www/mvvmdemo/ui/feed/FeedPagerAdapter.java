package com.zeng.www.mvvmdemo.ui.feed;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zeng.www.mvvmdemo.ui.feed.blog.BlogFragment;
import com.zeng.www.mvvmdemo.ui.feed.openSource.OpenSourceFragment;

/**
 * description:Data：2018/1/29-15:51
 *
 * @author admin
 */

public class FeedPagerAdapter extends FragmentStatePagerAdapter {
    private int mTabCount;

    public FeedPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return BlogFragment.newInstance();
            case 1:
                return OpenSourceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setTabCount(int tabCount) {
        mTabCount = tabCount;
    }

}
