package com.example.admin.abcfashions.WebService;

import com.example.admin.abcfashions.WebService.pojo.User;

/**
 * Created by admin on 12/16/17.
 */

public class LoginEvent {
    private User user;

    public LoginEvent(User user) {
        this.user = user;
    }

    public User getServerResponse() {
        return user;
    }

    public void setServerResponse(User user) {
        this.user = user;
    }
}