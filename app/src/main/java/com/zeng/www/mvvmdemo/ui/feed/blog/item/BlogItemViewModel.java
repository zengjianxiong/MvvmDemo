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

    public ObservableField<String> imageUrl;
    public ObservableField<String> title;
    public ObservableField<String> author;
    public ObservableField<String> date;
    public ObservableField<String> content;
    private BlogResponse.Blog mBlog;
    private BlogItemViewModelListener mListener;


    public BlogItemViewModel(BlogResponse.Blog blog, BlogItemViewModelListener listener) {
        this.mBlog = blog;
        this.mListener = listener;
        imageUrl = new ObservableField<>(mBlog.getImgUrl());
        title = new ObservableField<>(mBlog.getTitle());
        author = new ObservableField<>(mBlog.getAuthor());
        date = new ObservableField<>(mBlog.getData());
        content = new ObservableField<>(mBlog.getDescription());
    }

    public void onItemClick() {
        mListener.onItemClick(mBlog);
    }

    public boolean onItemLongClick() {
         return mListener.onItemLongClick(mBlog);
    }


    public interface BlogItemViewModelListener {
        void onItemClick(BlogResponse.Blog blog);

        boolean onItemLongClick(BlogResponse.Blog blog);
    }
}
