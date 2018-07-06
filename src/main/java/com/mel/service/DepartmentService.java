package com.mel.service;

import java.util.List;
import java.util.Map;

import com.mel.model.Department;

public interface DepartmentService {
  public List<Department> getAllDepartments();
  public Map<Long,String> getDepartmentsAsMap();
}
