package com.zeng.www.mvvmdemo.utils;

import android.content.Context;
import android.databinding.BindingAdapter;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;
import com.zeng.www.mvvmdemo.data.model.api.OpenSourceResponse;
import com.zeng.www.mvvmdemo.ui.feed.blog.item.BlogAdapter;
import com.zeng.www.mvvmdemo.ui.feed.openSource.item.OpenSourceAdapter;
import com.zeng.www.mvvmdemo.utils.glide.GlideApp;

import java.util.ArrayList;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        GlideApp.with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(imageView);
    }


    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, ArrayList<BlogResponse.Blog> blogs) {
        BlogAdapter blogAdapter = (BlogAdapter) recyclerView.getAdapter();
        if (blogAdapter != null) {
            blogAdapter.clearItems();
            blogAdapter.addItems(blogs);
        }

    }

    @BindingAdapter({"adapter"})
    public static void addOpenSourceItems(RecyclerView recyclerView, ArrayList<OpenSourceResponse.Repo> repos) {
        OpenSourceAdapter openSourceAdapter = (OpenSourceAdapter) recyclerView.getAdapter();
        if (openSourceAdapter != null) {
            openSourceAdapter.setNewData(repos);
        }

    }
}
