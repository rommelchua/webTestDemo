package com.mel.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.mel.model.User;

public class UserDaoTest {

  private EmbeddedDatabase db;
  private DriverManagerDataSource ds;
  private UserDao userDao;

  @Before
  public void setUp() {
    db = new EmbeddedDatabaseBuilder()
             .setType(EmbeddedDatabaseType.H2)
             .addScript("db/sql/create-db.sql")
             .addScript("db/sql/insert-data.sql")
             .build();

    ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.h2.Driver");
    ds.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    ds.setUsername("sa");
    ds.setPassword("");

    userDao = new UserDaoImpl();
    userDao.setDataSource(ds);
  }

  @Test
  public void testFindByUserId() {
    User user = userDao.findByUserId(1L);
    assertTrue(user != null);
    assertTrue(user.getId().equals(1L));
    assertTrue(user.getDepId().equals(1L));
    assertTrue(user.getName().equals("Rommel Chua"));
    assertTrue(user.getEmail().equals("rc@yahoo.com"));

    user = userDao.findByUserId(2L);
    assertTrue(user != null);
    assertTrue(user.getId().equals(2L));
    assertTrue(user.getDepId().equals(2L));
    assertTrue(user.getName().equals("Judy Chua"));
    assertTrue(user.getEmail().equals("jc@yahoo.com"));
  }


  public void testFindByUserIdMissingUser() {
    User user = userDao.findByUserId(-1L);
    assertTrue(user != null);
  }

  @After
  public void tearDown() {
    db.shutdown();
  }
}