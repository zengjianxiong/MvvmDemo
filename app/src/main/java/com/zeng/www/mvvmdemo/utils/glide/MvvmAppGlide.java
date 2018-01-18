package com.zeng.www.mvvmdemo.utils.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;

import com.bumptech.glide.module.AppGlideModule;



/**
 * description:Data：2018/1/18-17:26
 *
 * @author admin
 */

@GlideModule
public class MvvmAppGlide extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
    }
}
