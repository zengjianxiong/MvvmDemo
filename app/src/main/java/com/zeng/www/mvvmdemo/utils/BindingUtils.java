package com.zeng.www.mvvmdemo.utils;

import android.content.Context;
import android.databinding.BindingAdapter;

import android.widget.ImageView;

import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.utils.glide.GlideApp;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        GlideApp.with(context)
                .load(url)
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(imageView);
    }
}
