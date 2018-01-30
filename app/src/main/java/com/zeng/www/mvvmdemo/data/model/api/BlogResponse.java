package com.zeng.www.mvvmdemo.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * description:Data：2018/1/29-17:12
 *
 * @author admin
 */

public class BlogResponse {

    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private List<Blog> datas;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Blog> getDatas() {
        return datas;
    }

    public void setDatas(List<Blog> datas) {
        this.datas = datas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogResponse that = (BlogResponse) o;

        if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return datas != null ? datas.equals(that.datas) : that.datas == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (datas != null ? datas.hashCode() : 0);
        return result;
    }

    public static class Blog {

        @Expose
        @SerializedName("title")
        private String title;


        @Expose
        @SerializedName("description")
        private String description;

        @Expose
        @SerializedName("author")
        private String author;

        @Expose
        @SerializedName("img_url")
        private String imgUrl;

        @Expose
        @SerializedName("blog_url")
        private String blogUrl;

        @Expose
        @SerializedName("published_at")
        private String data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getBlogUrl() {
            return blogUrl;
        }

        public void setBlogUrl(String blogUrl) {
            this.blogUrl = blogUrl;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Blog blog = (Blog) o;

            if (title != null ? !title.equals(blog.title) : blog.title != null) return false;
            if (description != null ? !description.equals(blog.description) : blog.description != null)
                return false;
            if (author != null ? !author.equals(blog.author) : blog.author != null) return false;
            if (imgUrl != null ? !imgUrl.equals(blog.imgUrl) : blog.imgUrl != null) return false;
            if (blogUrl != null ? !blogUrl.equals(blog.blogUrl) : blog.blogUrl != null)
                return false;
            return data != null ? data.equals(blog.data) : blog.data == null;
        }

        @Override
        public int hashCode() {
            int result = title != null ? title.hashCode() : 0;
            result = 31 * result + (description != null ? description.hashCode() : 0);
            result = 31 * result + (author != null ? author.hashCode() : 0);
            result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
            result = 31 * result + (blogUrl != null ? blogUrl.hashCode() : 0);
            result = 31 * result + (data != null ? data.hashCode() : 0);
            return result;
        }
    }


}
