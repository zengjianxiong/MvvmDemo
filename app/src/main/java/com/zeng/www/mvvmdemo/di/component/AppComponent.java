package com.zeng.www.mvvmdemo.di.component;

import android.app.Application;

import com.zeng.www.mvvmdemo.MvvmApp;
import com.zeng.www.mvvmdemo.di.builder.ActivityBuilder;
import com.zeng.www.mvvmdemo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * description:Data：2018/1/11-16:34
 *
 * @author admin
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(MvvmApp mvvmApp);
}
