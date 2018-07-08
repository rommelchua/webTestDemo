package com.mel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mel.model.User;

public interface UserDao {
  public User createUser(User user);
  public User updateUser(User user);
  public User findByUserId(Long userId);
  public List<User> findAllUsers();
  //public void updateUser(User user);
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}
