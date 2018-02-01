package com.zeng.www.mvvmdemo.ui.feed.blog;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.ui.base.BaseViewModel;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * description:Data：2018/1/29-16:49
 *
 * @author admin
 */

public class BlogViewModel extends BaseViewModel<BlogNavigator> {

    private ObservableArrayList<BlogResponse.Blog> blogObservableArrayList = new ObservableArrayList<>();
    private MutableLiveData<List<BlogResponse.Blog>> mBlogListLiveData;

    public BlogViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        mBlogListLiveData = new MutableLiveData<>();
        fetchBlog();
    }

    public void fetchBlog() {
        getCompositeDisposable().add(
                getDataManager().doServiceGetBlogApiCall()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<BlogResponse>() {
                            @Override
                            public void accept(BlogResponse blogResponse) throws Exception {
                                if (blogResponse != null && blogResponse.getDatas() != null) {
                                    mBlogListLiveData.setValue(blogResponse.getDatas());
                                }

                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        })
        );
    }

    public MutableLiveData<List<BlogResponse.Blog>> getBlogListLiveData() {
        return mBlogListLiveData;
    }

    public void addBlogItemsToList(List<BlogResponse.Blog> blogList) {
        blogObservableArrayList.clear();
        blogObservableArrayList.addAll(blogList);
    }

    public ObservableArrayList<BlogResponse.Blog> getBlogObservableArrayList() {
        return blogObservableArrayList;
    }
}
