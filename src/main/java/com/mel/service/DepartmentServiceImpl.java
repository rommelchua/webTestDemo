package com.mel.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mel.dao.DepartmentDao;
import com.mel.model.Department;

@Service
@Qualifier("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired
  private DepartmentDao departmentDao;

  public List<Department> getAllDepartments() {
    return departmentDao.findAllDepartments();
  }

  public Map<Long,String> getDepartmentsAsMap() {
    return getAllDepartments().stream().collect(Collectors.toMap(Department::getId, Department::getName));
  }

  public DepartmentDao getDepartmentDao() {
    return departmentDao;
  }

  public void setDepartmentDao(DepartmentDao departmentDao) {
    this.departmentDao = departmentDao;
  }
}
