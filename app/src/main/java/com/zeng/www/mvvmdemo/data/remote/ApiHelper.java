package com.zeng.www.mvvmdemo.data.remote;

import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.data.model.api.LoginRequest;
import com.zeng.www.mvvmdemo.data.model.api.LoginResponse;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

/**
 * description:Data：2018/1/12-11:27
 *
 * @author admin
 */

public interface ApiHelper {
    /**
     * 登录接口
     *
     * @param serviceLoginRequest
     * @return
     */
    Single<LoginResponse> doServiceLoginApiCall(LoginRequest.ServiceLoginRequest serviceLoginRequest);

    ApiHeader getApiHeader();

    /**
     * 获取blog列表接口
     *
     * @return BlogResponse
     */

    Single<BlogResponse> doServiceGetBlogApiCall();

}
