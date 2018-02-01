package com.zeng.www.mvvmdemo.ui.feed.openSource;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.data.model.api.OpenSourceResponse;
import com.zeng.www.mvvmdemo.ui.base.BaseViewModel;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * description:Data：2018/2/1-15:51
 *
 * @author admin
 */

public class OpenSourceViewModel extends BaseViewModel<OpenSourceNavigator> {

    private ObservableArrayList<OpenSourceResponse.Repo> repoObservableArrayList = new ObservableArrayList<>();
    private MutableLiveData<List<OpenSourceResponse.Repo>> openSourceResponseMutableLiveData;

    public OpenSourceViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        openSourceResponseMutableLiveData = new MutableLiveData<>();
        fetchRepos();
    }

    private void fetchRepos() {
        getCompositeDisposable().add(getDataManager()
                .getOpenSourceApiCall().subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<OpenSourceResponse>() {
                    @Override
                    public void accept(OpenSourceResponse response) throws Exception {

                        if (response != null && response.getData() != null) {
                            openSourceResponseMutableLiveData.setValue(response.getData());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }

    public MutableLiveData<List<OpenSourceResponse.Repo>> getOpenSourceListData() {
        return openSourceResponseMutableLiveData;

    }

    public void setRepoItemsToLive(List<OpenSourceResponse.Repo> repos) {
        repoObservableArrayList.clear();
        repoObservableArrayList.addAll(repos);
    }

    public ObservableArrayList<OpenSourceResponse.Repo> getRepoObservableArrayList() {
        return repoObservableArrayList;
    }

}
