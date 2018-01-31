package com.zeng.www.mvvmdemo.ui.feed.blog;


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
import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.databinding.FragmentBlogBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseFragment;
import com.zeng.www.mvvmdemo.ui.feed.blog.item.BlogAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogFragment extends BaseFragment<FragmentBlogBinding, BlogViewModel> implements BlogNavigator, BlogAdapter.BlogAdapterListener {
    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    BlogAdapter mBlogAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private BlogViewModel mBlogViewModel;

    FragmentBlogBinding mFragmentBlogBinding;

    public static BlogFragment newInstance() {
        BlogFragment fragment = new BlogFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBlogViewModel.setNavigator(this);
        mBlogAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentBlogBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();

    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentBlogBinding.blogRecyclerView.setAdapter(mBlogAdapter);
        mFragmentBlogBinding.blogRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentBlogBinding.blogRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void subscribeToLiveData() {
        mBlogViewModel.getBlogListLiveData().observe(this, new Observer<List<BlogResponse.Blog>>() {
            @Override
            public void onChanged(@Nullable List<BlogResponse.Blog> blogList) {
                mBlogViewModel.addBlogItemsToList(blogList);
            }
        });
    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blog;
    }

    @Override
    protected BlogViewModel getViewModel() {
        mBlogViewModel = ViewModelProviders.of(this, mViewModelFactory).get(BlogViewModel.class);
        return mBlogViewModel;
    }

    @Override
    public void onRetryClick() {
        mBlogViewModel.fetchBlog();
    }
}
