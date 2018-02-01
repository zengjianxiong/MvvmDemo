package com.zeng.www.mvvmdemo.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.data.model.api.LoginRequest;
import com.zeng.www.mvvmdemo.data.model.api.LoginResponse;
import com.zeng.www.mvvmdemo.data.model.api.OpenSourceResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * description:Data：2018/1/15-15:36
 *
 * @author admin
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        this.mApiHeader = apiHeader;
    }


    @Override
    public Single<BlogResponse> doServiceGetBlogApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(OpenSourceResponse.class);
    }

    @Override
    public Single<LoginResponse> doServiceLoginApiCall(LoginRequest.ServiceLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }
}
