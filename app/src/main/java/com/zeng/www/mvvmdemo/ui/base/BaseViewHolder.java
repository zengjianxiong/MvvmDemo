package com.zeng.www.mvvmdemo.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * description:Data：2018/1/30-10:55
 *
 * @author admin
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
