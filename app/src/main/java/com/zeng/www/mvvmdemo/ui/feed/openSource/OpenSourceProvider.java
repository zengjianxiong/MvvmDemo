package com.zeng.www.mvvmdemo.ui.feed.openSource;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * description:Data：2018/2/1-16:11
 *
 * @author admin
 */

@Module
public abstract class OpenSourceProvider {

    @ContributesAndroidInjector(modules = {OpenSourceModule.class})
    abstract OpenSourceFragment providerOpenSourceFragment();
}
