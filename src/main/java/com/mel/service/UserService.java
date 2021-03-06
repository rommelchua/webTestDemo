package com.mel.service;

import java.util.List;

import com.mel.model.User;

public interface UserService {
  public List<User> getAllUsers();
  public User findUserById(Long id);
  public User createUser(User user);
  public User updateUser(User user);
}
