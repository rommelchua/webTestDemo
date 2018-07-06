package com.mel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mel.model.User;
import com.mel.service.UserService;

@RestController
public class BaseRestController {
  @Autowired
  private UserService userService;

  @RequestMapping(value="/rs/users/{id}", method=RequestMethod.GET)
  public User user(@PathVariable("id") Long id) {
    return userService.findUserById(id);
  }
}