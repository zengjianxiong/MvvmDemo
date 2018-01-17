package com.zeng.www.mvvmdemo.ui.login;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.data.model.api.LoginRequest;
import com.zeng.www.mvvmdemo.data.model.api.LoginResponse;
import com.zeng.www.mvvmdemo.ui.base.BaseViewModel;
import com.zeng.www.mvvmdemo.utils.AppLogger;
import com.zeng.www.mvvmdemo.utils.CommonUtils;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * description:Data：2018/1/15-10:46
 *
 * @author admin
 */

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(DataManager dataManager,
                          SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }

    public void onGoogleLoginClick() {
    }

    public void onFacebookLoginClick() {
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {


        getCompositeDisposable().add(
                getDataManager()
                        .doServiceLoginApiCall(new LoginRequest.ServiceLoginRequest(email, password))
                        .subscribeOn(getSchedulerProvider().io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                AppLogger.d("doOnSubscribe"+Thread.currentThread().getName());
                            }
                        })
                        .subscribeOn(getSchedulerProvider().ui())
                        .observeOn(getSchedulerProvider().ui())
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {
                                AppLogger.d("doFinally"+Thread.currentThread().getName());
                            }
                        })
                        .subscribe(new Consumer<LoginResponse>() {
                            @Override
                            public void accept(LoginResponse response) throws Exception {
                               getDataManager().updateUserInfo(
                                       response.getAccessToken(),
                                       response.getUserId(),
                                       DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                       response.getUserName(),
                                       response.getUserEmail(),
                                       response.getGoogleProfilePicUrl());
                               getNavigator().openMainActivity();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                getNavigator().handleError(throwable);
                            }
                        })
        );
    }
}
