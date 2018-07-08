package com.mel.model;

import org.springframework.util.StringUtils;

public class User {
  private Long id;
  private String name;
  private String email;
  private Long depId;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getDepId() {
    return depId;
  }

  public void setDepId(Long depId) {
    this.depId = depId;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("{id: ");
    builder.append(this.getId());
    builder.append(", name: ");
    builder.append(StringUtils.isEmpty(this.getName())?"null":this.getName());
    builder.append(", email: ");
    builder.append(StringUtils.isEmpty(this.getEmail())?"null":this.getEmail());
    builder.append(", depId: ");
    builder.append(this.getDepId());
    builder.append("}");
    return builder.toString();
  }
}
