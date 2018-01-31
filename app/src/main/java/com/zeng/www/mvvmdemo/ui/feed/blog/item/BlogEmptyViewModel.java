package com.zeng.www.mvvmdemo.ui.feed.blog.item;

/**
 * description:Data：2018/1/31-15:40
 *
 * @author admin
 */

public class BlogEmptyViewModel {

    private BlogEmptyViewModelListener mListener;

    public BlogEmptyViewModel(BlogEmptyViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface BlogEmptyViewModelListener {
        void onRetryClick();
    }
}
