package com.zeng.www.mvvmdemo.ui.feed;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * description:Data：2018/1/29-11:47
 *
 * @author admin
 */

@Module
public class FeedActivityModule {

    @Provides
    FeedViewModel provideFeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new FeedViewModel(dataManager, schedulerProvider);
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(FeedActivity feedActivity) {
        return new FeedPagerAdapter(feedActivity.getSupportFragmentManager());
    }
}
