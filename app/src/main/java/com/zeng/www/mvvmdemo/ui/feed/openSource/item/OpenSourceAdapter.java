package com.zeng.www.mvvmdemo.ui.feed.openSource.item;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zeng.www.mvvmdemo.BR;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.data.model.api.OpenSourceResponse;

import java.util.List;

import javax.inject.Inject;

/**
 * description:Data：2018/2/1-17:24
 *
 * @author admin
 */

public class OpenSourceAdapter extends BaseQuickAdapter<OpenSourceResponse.Repo,OpenSourceAdapter.OpenSourceViewHolder> {

    public OpenSourceAdapter(int layoutResId, @Nullable List<OpenSourceResponse.Repo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(OpenSourceViewHolder helper, OpenSourceResponse.Repo item) {
        ViewDataBinding binding = helper.getBinding();
        binding.setVariable(BR.repo, item);
        binding.executePendingBindings();
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public static class OpenSourceViewHolder extends BaseViewHolder {

        public OpenSourceViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}
