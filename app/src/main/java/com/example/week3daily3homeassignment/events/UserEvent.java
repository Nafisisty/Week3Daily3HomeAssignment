package com.example.week3daily3homeassignment.events;

import com.example.week3daily3homeassignment.model.user.User;

public class UserEvent {
    private User user;

    public UserEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
