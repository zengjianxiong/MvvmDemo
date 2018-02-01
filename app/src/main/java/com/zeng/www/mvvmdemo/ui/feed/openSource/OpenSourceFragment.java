package com.zeng.www.mvvmdemo.ui.feed.openSource;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.zeng.www.mvvmdemo.BR;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.data.model.api.OpenSourceResponse;
import com.zeng.www.mvvmdemo.databinding.FragmentOpenSourceBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseFragment;
import com.zeng.www.mvvmdemo.ui.feed.openSource.item.OpenSourceAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OpenSourceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OpenSourceFragment extends BaseFragment<FragmentOpenSourceBinding, OpenSourceViewModel> implements OpenSourceNavigator {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    OpenSourceAdapter adapter;

    @Inject
    LinearLayoutManager layoutManager;

    private OpenSourceViewModel openSourceViewModel;

    FragmentOpenSourceBinding openSourceBinding;


    public static OpenSourceFragment newInstance() {
        OpenSourceFragment fragment = new OpenSourceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openSourceViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        openSourceBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
        openSourceViewModel.getOpenSourceListData().observe(this, new Observer<List<OpenSourceResponse.Repo>>() {
            @Override
            public void onChanged(@Nullable List<OpenSourceResponse.Repo> repos) {
                openSourceViewModel.setRepoItemsToLive(repos);
            }
        });

    }

    private void setUp() {
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        openSourceBinding.openSourceRecyclerView.setLayoutManager(layoutManager);
        openSourceBinding.openSourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        openSourceBinding.openSourceRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_open_source;
    }

    @Override
    protected OpenSourceViewModel getViewModel() {
        openSourceViewModel = ViewModelProviders.of(this, viewModelFactory).get(OpenSourceViewModel.class);
        return openSourceViewModel;
    }

}
