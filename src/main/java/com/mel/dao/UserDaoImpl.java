package com.mel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mel.model.User;

@Repository
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Transactional(rollbackFor = Exception.class)
  public User createUser(User user) {
    KeyHolder key = new GeneratedKeyHolder();
    String query = "insert into user (name,email,dep_id) values (?,?,?)";
    jdbcTemplate.update(new PreparedStatementCreator() {
        @Override
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
          final PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
          ps.setString(1, user.getName());
          ps.setString(2, user.getEmail());
          ps.setLong(3, user.getDepId());
          return ps;
        }
    },key);
    user.setId(key.getKey().longValue());
    return user;
  }

  public User updateUser(User user) {
    String query = "update user set name = ?,email = ?,dep_id = ? where id=?";
    jdbcTemplate.update(query, new Object[]{user.getName(), user.getEmail(),user.getDepId(),user.getId()});
    return user;
  }

  public User findByUserId(Long userId) {
    String query = "select * from user where id = ?";
    return jdbcTemplate.queryForObject(query, new Object[] {userId}, new BeanPropertyRowMapper<User>(User.class));
  }

  public List<User> findAllUsers() {
    String query = "select * from user";
    List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
    return users;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
