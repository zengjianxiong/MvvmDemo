package com.zeng.www.mvvmdemo.ui.feed.openSource;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.ViewModelProviderFactory;
import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.data.model.api.OpenSourceResponse;
import com.zeng.www.mvvmdemo.ui.feed.openSource.item.OpenSourceAdapter;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * description:Data：2018/2/1-16:07
 *
 * @author admin
 */

@Module
public class OpenSourceModule {

    @Provides
    OpenSourceViewModel openSourceViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new OpenSourceViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideOpenSourceViewModel(OpenSourceViewModel openSourceViewModel) {
        return new ViewModelProviderFactory<>(openSourceViewModel);
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(R.layout.item_open_source_view, new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(OpenSourceFragment openSourceFragment) {
        return new LinearLayoutManager(openSourceFragment.getActivity());
    }
}
