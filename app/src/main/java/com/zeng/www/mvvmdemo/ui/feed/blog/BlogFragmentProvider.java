package com.zeng.www.mvvmdemo.ui.feed.blog;

import com.zeng.www.mvvmdemo.ui.feed.blog.BlogFragment;
import com.zeng.www.mvvmdemo.ui.feed.blog.BlogFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * description:Data：2018/1/29-16:54
 *
 * @author admin
 */

@Module
public abstract class BlogFragmentProvider {

    @ContributesAndroidInjector(modules = BlogFragmentModule.class)
    abstract BlogFragment provideBlogFragmentFactory();
}
