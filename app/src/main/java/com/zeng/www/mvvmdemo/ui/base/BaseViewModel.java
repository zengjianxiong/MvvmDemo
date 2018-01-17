package com.zeng.www.mvvmdemo.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * description:Data：2018/1/12-10:04
 *
 * @author admin
 */

public abstract class BaseViewModel<N> extends ViewModel {

    //导航器
    private N mNavigator;
    private DataManager mDataManager;
    private SchedulerProvider mSchedulerProvider;

    private ObservableBoolean mBoolean = new ObservableBoolean(false);

    private CompositeDisposable mCompositeDisposable;

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        mCompositeDisposable = new CompositeDisposable();
    }

    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N navigator) {
        mNavigator = navigator;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public void setDataManager(DataManager dataManager) {
        mDataManager = dataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public void setSchedulerProvider(SchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    public ObservableBoolean getBoolean() {
        return mBoolean;
    }

    public void setBoolean(ObservableBoolean aBoolean) {
        mBoolean = aBoolean;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
