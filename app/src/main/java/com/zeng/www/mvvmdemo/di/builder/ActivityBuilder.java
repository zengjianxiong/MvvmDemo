package com.zeng.www.mvvmdemo.di.builder;

import com.zeng.www.mvvmdemo.ui.feed.blog.BlogFragmentProvider;
import com.zeng.www.mvvmdemo.ui.feed.FeedActivity;
import com.zeng.www.mvvmdemo.ui.feed.FeedActivityModule;
import com.zeng.www.mvvmdemo.ui.login.LoginActivity;
import com.zeng.www.mvvmdemo.ui.login.LoginActivityModule;
import com.zeng.www.mvvmdemo.ui.main.MainActivity;
import com.zeng.www.mvvmdemo.ui.main.MainActivityModule;
import com.zeng.www.mvvmdemo.ui.splash.SplashActivity;
import com.zeng.www.mvvmdemo.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * description:Data：2018/1/11-16:49
 *
 * @author admin
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {FeedActivityModule.class, BlogFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

}
