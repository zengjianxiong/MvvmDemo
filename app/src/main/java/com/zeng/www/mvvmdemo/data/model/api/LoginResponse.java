package com.zeng.www.mvvmdemo.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * description:Data：2018/1/17-11:41
 *
 * @author admin
 */

public class LoginResponse {
    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("user_id")
    private Long userId;

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("email")
    private String userEmail;

    @Expose
    @SerializedName("server_profile_pic_url")
    private String serverProfilePicUrl;

    @Expose
    @SerializedName("fb_profile_pic_url")
    private String fbProfilePicUrl;

    @Expose
    @SerializedName("google_profile_pic_url")
    private String googleProfilePicUrl;

    @Expose
    @SerializedName("message")
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getServerProfilePicUrl() {
        return serverProfilePicUrl;
    }

    public void setServerProfilePicUrl(String serverProfilePicUrl) {
        this.serverProfilePicUrl = serverProfilePicUrl;
    }

    public String getFbProfilePicUrl() {
        return fbProfilePicUrl;
    }

    public void setFbProfilePicUrl(String fbProfilePicUrl) {
        this.fbProfilePicUrl = fbProfilePicUrl;
    }

    public String getGoogleProfilePicUrl() {
        return googleProfilePicUrl;
    }

    public void setGoogleProfilePicUrl(String googleProfilePicUrl) {
        this.googleProfilePicUrl = googleProfilePicUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", userId=" + userId +
                ", accessToken='" + accessToken + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", serverProfilePicUrl='" + serverProfilePicUrl + '\'' +
                ", fbProfilePicUrl='" + fbProfilePicUrl + '\'' +
                ", googleProfilePicUrl='" + googleProfilePicUrl + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginResponse that = (LoginResponse) o;

        return (statusCode != null ? statusCode.equals(that.statusCode) : that.statusCode == null) &&
                (userId != null ? userId.equals(that.userId) : that.userId == null) &&
                (accessToken != null ? accessToken.equals(that.accessToken) : that.accessToken == null) &&
                (userName != null ? userName.equals(that.userName) : that.userName == null) &&
                (userEmail != null ? userEmail.equals(that.userEmail) : that.userEmail == null) &&
                (serverProfilePicUrl != null ? serverProfilePicUrl.equals(that.serverProfilePicUrl) : that.serverProfilePicUrl == null) &&
                (fbProfilePicUrl != null ? fbProfilePicUrl.equals(that.fbProfilePicUrl) : that.fbProfilePicUrl == null) &&
                (googleProfilePicUrl != null ? googleProfilePicUrl.equals(that.googleProfilePicUrl) : that.googleProfilePicUrl == null) &&
                (message != null ? message.equals(that.message) : that.message == null);
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (serverProfilePicUrl != null ? serverProfilePicUrl.hashCode() : 0);
        result = 31 * result + (fbProfilePicUrl != null ? fbProfilePicUrl.hashCode() : 0);
        result = 31 * result + (googleProfilePicUrl != null ? googleProfilePicUrl.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
