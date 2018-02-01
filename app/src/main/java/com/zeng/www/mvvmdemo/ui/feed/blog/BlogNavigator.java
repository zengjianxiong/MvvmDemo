package com.zeng.www.mvvmdemo.ui.feed.blog;

import com.zeng.www.mvvmdemo.data.model.api.BlogResponse;

import java.util.List;

/**
 * description:Data：2018/1/29-16:49
 *
 * @author admin
 */

public interface BlogNavigator {

    void updateBlog(List<BlogResponse.Blog> blogList);
}
