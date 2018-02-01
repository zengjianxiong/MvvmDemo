package com.zeng.www.mvvmdemo.ui.feed.blog.item;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.databinding.ItemBlogEmptyViewBinding;
import com.zeng.www.mvvmdemo.databinding.ItemBlogViewBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseViewHolder;

import java.util.List;

/**
 * description:Data：2018/1/30-10:54
 *
 * @author admin
 */

public class BlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private BlogAdapterListener mListener;

    private List<BlogResponse.Blog> mBlogList;

    public BlogAdapter(List<BlogResponse.Blog> blogList) {
        this.mBlogList = blogList;
    }

    public void setListener(BlogAdapterListener listener) {
        mListener = listener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemBlogViewBinding blogViewBinding =
                        ItemBlogViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new BlogViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemBlogEmptyViewBinding blogEmptyViewBinding =
                        ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new BlogEmptyHolder(blogEmptyViewBinding);
        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.onBind(position);
    }


    @Override
    public int getItemViewType(int position) {
        if (mBlogList != null && mBlogList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mBlogList != null && mBlogList.size() > 0) {
            return mBlogList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<BlogResponse.Blog> blogList) {
        mBlogList.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mBlogList.clear();
    }


    private class BlogViewHolder extends BaseViewHolder implements BlogItemViewModel.BlogItemViewModelListener {

        private ItemBlogViewBinding mBinding;

        private BlogItemViewModel mBlogItemViewModel;

        public BlogViewHolder(ItemBlogViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;

        }

        @Override
        public void onBind(int position) {
            BlogResponse.Blog blog = mBlogList.get(position);

            mBlogItemViewModel = new BlogItemViewModel(blog, this);

            mBinding.setViewModel(mBlogItemViewModel);
            mBinding.executePendingBindings();
        }


        @Override
        public void onItemClick(BlogResponse.Blog blog) {
            Toast.makeText(itemView.getContext(), "onItemClick", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(BlogResponse.Blog blog) {
            Toast.makeText(itemView.getContext(), "onItemLongClick", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private class BlogEmptyHolder extends BaseViewHolder implements BlogEmptyViewModel.BlogEmptyViewModelListener {
        private ItemBlogEmptyViewBinding mBinding;

        public BlogEmptyHolder(ItemBlogEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {

            BlogEmptyViewModel emptyViewModel = new BlogEmptyViewModel(this);
            mBinding.setViewModel(emptyViewModel);

        }

        @Override
        public void onRetryClick() {
            if (mListener != null) {
                mListener.onRetryClick();
            }
        }
    }

    public interface BlogAdapterListener {
        void onRetryClick();
    }

}
