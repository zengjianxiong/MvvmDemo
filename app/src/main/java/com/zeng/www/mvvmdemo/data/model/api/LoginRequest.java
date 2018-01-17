package com.zeng.www.mvvmdemo.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * description:Data：2018/1/17-11:14
 *
 * @author admin
 */

public class LoginRequest {
    public LoginRequest() {

    }

    public static class ServiceLoginRequest {
        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public ServiceLoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ServiceLoginRequest that = (ServiceLoginRequest) o;

            return (email != null ? email.equals(that.email) : that.email == null) &&
                    (password != null ? password.equals(that.password) : that.password == null);
        }

        @Override
        public int hashCode() {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }
    }
}
