package com.mel.model;

import org.springframework.util.StringUtils;

public class Department {
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("{id: ");
    builder.append(this.getId());
    builder.append(", name: ");
    builder.append(StringUtils.isEmpty(this.getName())?"null":this.getName());
    builder.append("}");
    return builder.toString();
  }
}
