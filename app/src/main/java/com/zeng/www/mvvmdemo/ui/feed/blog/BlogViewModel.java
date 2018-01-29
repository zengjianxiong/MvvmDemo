package com.zeng.www.mvvmdemo.ui.feed.blog;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.ui.base.BaseViewModel;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import io.reactivex.functions.Consumer;

/**
 * description:Data：2018/1/29-16:49
 *
 * @author admin
 */

public class BlogViewModel extends BaseViewModel<BlogNavigator> {
    public BlogViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        fetchBlog();
    }

    private void fetchBlog() {
        getCompositeDisposable().add(
                getDataManager().doServiceGetBlogApiCall().subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().io())
                        .subscribe(new Consumer<BlogResponse>() {
                            @Override
                            public void accept(BlogResponse o) throws Exception {

                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        })
        );
    }

    public void getBlogListLiveData() {

    }
}
