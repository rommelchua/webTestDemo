package com.mel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mel.dao.UserDao;
import com.mel.model.User;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService {
  @Autowired
  UserDao userDao;

  public List<User> getAllUsers() {
    return userDao.findAllUsers();
  }

  public User findUserById(Long id) {
    return userDao.findByUserId(id);
  }

  public User saveUser(User user) {
    return userDao.createUser(user);
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
