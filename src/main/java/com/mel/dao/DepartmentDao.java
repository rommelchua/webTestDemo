package com.mel.dao;

import java.util.List;

import com.mel.model.Department;

public interface DepartmentDao {
  public void createDepartment(Department department);
  public Department findByDepId(Long depId);
  public List<Department> findAllDepartments();
}
