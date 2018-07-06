package com.mel.dao;
import java.util.List;

import javax.sql.DataSource;

import com.mel.model.User;

public interface UserDao {
  public void createUser(User user);
  public User findByUserId(Long userId);
  public List<User> findAllUsers();
  //public void updateUser(User user);
  public void setDataSource(DataSource dataSource);
}
