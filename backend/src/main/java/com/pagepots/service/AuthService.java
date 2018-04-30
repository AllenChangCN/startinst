package com.pagepots.service;

import com.pagepots.entities.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
