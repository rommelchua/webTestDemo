package com.mel.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mel.exceptions.UserIdMismatchException;
import com.mel.model.User;
import com.mel.service.UserService;

@RestController
public class BaseRestController {
  @Autowired
  private UserService userService;
  private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseRestController.class);

  @RequestMapping(value="/rs/users/{id}", method=RequestMethod.GET)
  public User getUser(@PathVariable("id") Long id) {
    try {
      logger.info("getting user with id="+id);
      return userService.findUserById(id);
    } catch (Exception e) {
      logger.error("Error encountered while getting user=" + id + ". Error is:");
      e.printStackTrace();
      throw e;
    }
  }

  @RequestMapping(value="/rs/user", method=RequestMethod.POST)
  public User createUser(@RequestBody User user) {
    try {
      logger.info("creating user with User=" + user.toString());
      return userService.createUser(user);      
    } catch (Exception e) {
      logger.error("Error encountered while creating user=" + user.toString() + ". Error is:");
      e.printStackTrace();
      throw e;
    }
  }

  @RequestMapping(value="/rs/users/{id}", method=RequestMethod.PUT)
  public User saveUser(@PathVariable("id") Long id, @RequestBody User user) {
    try {
      logger.info("updating user with User=" + user.toString());
      if (id == null || !id.equals(user.getId())) {
        throw new UserIdMismatchException(user, id);
      }
      return userService.updateUser(user);      
    } catch (Exception e) {
      logger.error("Error encountered while updating user=" + user.toString() + ". Error is:");
      e.printStackTrace();
      throw e;
    }
  }

  @ExceptionHandler({Exception.class,Throwable.class})
  public String errorEncountered(HttpServletResponse resp, Exception ex) {
    resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    return "{errorMessage: \"error encountered\"}";
  }
}