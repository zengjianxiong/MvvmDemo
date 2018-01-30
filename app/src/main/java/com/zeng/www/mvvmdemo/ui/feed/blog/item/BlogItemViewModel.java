package com.zeng.www.mvvmdemo.ui.feed.blog.item;

import android.databinding.ObservableField;

import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;

import java.util.List;

/**
 * description:Data：2018/1/30-11:04
 *
 * @author admin
 */

public class BlogItemViewModel {

    private ObservableField<String> mDescription;
    private ObservableField<String> mTitle;
    private ObservableField<String> mData;
    private ObservableField<String> mAuthor;
    private ObservableField<String> mBlogUrl;
    private BlogResponse.Blog mBlog;
    private BlogItemViewModelListener mListener;

    private ObservableField<String> mImageUrl;

    public BlogItemViewModel(BlogResponse.Blog blog, BlogItemViewModelListener listener) {
        this.mBlog = blog;
        this.mListener = listener;
        mImageUrl = new ObservableField<>(mBlog.getImgUrl());
        mAuthor = new ObservableField<>(mBlog.getAuthor());
        mBlogUrl = new ObservableField<>(mBlog.getBlogUrl());
        mData = new ObservableField<>(mBlog.getData());
        mDescription = new ObservableField<>(mBlog.getDescription());
        mTitle = new ObservableField<>(mBlog.getTitle());
    }

    public void onItemClick() {
        mListener.onItemClick(mBlog);
    }

    public void onItemLongClick() {
        mListener.onItemLongClick(mBlog);
    }

    public interface BlogItemViewModelListener {
        void onItemClick(BlogResponse.Blog blog);

        void onItemLongClick(BlogResponse.Blog blog);
    }
}
