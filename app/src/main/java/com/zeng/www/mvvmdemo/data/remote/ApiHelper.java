package com.zeng.www.mvvmdemo.data.remote;

import com.zeng.www.mvvmdemo.data.model.api.LoginRequest;
import com.zeng.www.mvvmdemo.data.model.api.LoginResponse;

import io.reactivex.Single;

/**
 * description:Data：2018/1/12-11:27
 *
 * @author admin
 */

public interface ApiHelper {
    /**
     * 登录接口
     *
     * @return
     * @param serviceLoginRequest
     */
    Single<LoginResponse> doServiceLoginApiCall(LoginRequest.ServiceLoginRequest serviceLoginRequest);

    ApiHeader getApiHeader();
}
