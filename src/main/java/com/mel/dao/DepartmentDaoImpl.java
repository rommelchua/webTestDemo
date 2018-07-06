package com.mel.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mel.model.Department;

@Repository
@Qualifier("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {
  @Autowired
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  public void createDepartment(Department department) {
    String query = "insert into department (id,name) values (?,?)";
    jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.update(query, new Object[] {department.getId(),department.getName()});
  }

  public Department findByDepId(Long depId) {
    String query = "select * from department where id = ?";
    jdbcTemplate = new JdbcTemplate(dataSource);
    return jdbcTemplate.queryForObject(query, new Object[] {depId}, new BeanPropertyRowMapper<Department>(Department.class));
  }

  public List<Department> findAllDepartments() {
    String query = "select * from department";
    jdbcTemplate = new JdbcTemplate(dataSource);
    List<Department> departments = jdbcTemplate.query(query, new BeanPropertyRowMapper<Department>(Department.class));
    return departments;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
