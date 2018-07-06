package com.mel.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mel.model.User;

@Repository
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {
  @Autowired
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  public void createUser(User user) {
    String query = "insert into user (id,name,email,dep_id) values (?,?,?,?)";
    jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.update(query, new Object[] {user.getId(),user.getName(),user.getEmail(),user.getDepId()});
  }

  public User findByUserId(Long userId) {
    String query = "select * from user where id = ?";
    jdbcTemplate = new JdbcTemplate(dataSource);
    return jdbcTemplate.queryForObject(query, new Object[] {userId}, new BeanPropertyRowMapper<User>(User.class));
  }

  public List<User> findAllUsers() {
    String query = "select * from user";
    jdbcTemplate = new JdbcTemplate(dataSource);
    List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
    return users;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
