package com.zeng.www.mvvmdemo.ui.feed.blog.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.databinding.ItemBlogViewBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseViewHolder;

import java.util.List;

/**
 * description:Data：2018/1/30-10:54
 *
 * @author admin
 */

public class BlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<BlogResponse.Blog> mBlogList;

    public BlogAdapter(List<BlogResponse.Blog> blogList) {
        this.mBlogList = blogList;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mBlogList.size();
    }


    private class BlogViewHolder extends BaseViewHolder implements BlogItemViewModel.BlogItemViewModelListener{

        private ItemBlogViewBinding mBinding;

        private BlogItemViewModel mBlogItemViewModel;

        public BlogViewHolder(ItemBlogViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;

        }

        @Override
        public void onBind(int position) {
            BlogResponse.Blog blog = mBlogList.get(position);

            mBlogItemViewModel = new BlogItemViewModel(blog,this);

            mBinding.setViewModel(mBlogItemViewModel);
            mBinding.executePendingBindings();
        }


        @Override
        public void onItemClick(BlogResponse.Blog blog) {
            Toast.makeText(itemView.getContext(),"onItemClick",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onItemLongClick(BlogResponse.Blog blog) {
            Toast.makeText(itemView.getContext(),"onItemLongClick",Toast.LENGTH_SHORT).show();
        }
    }

}
