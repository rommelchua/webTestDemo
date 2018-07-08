package com.mel.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mel.model.City;
import com.mel.service.DepartmentService;
import com.mel.service.UserService;

@Controller
public class BaseController {
  //private static final String VIEW_INDEX = "index";
  private static final String VIEW_CITIES = "cities";
  private static final String VIEW_USERS = "users";
  private static final String ERROR_PAGE = "error";
  private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

  @Autowired
  private UserService userService;
  @Autowired
  private DepartmentService departmentService;

  @RequestMapping(value="/", method= RequestMethod.GET)
  public String welcome(ModelMap model){
    logger.info("index page visited");
    return users(model);
  }

  @RequestMapping(value="/users", method= RequestMethod.GET)
  public String users(ModelMap model){
    try {
      logger.info("users page visited");
      model.addAttribute("users",userService.getAllUsers());
      model.addAttribute("departments",departmentService.getAllDepartmentsAsMap());
      return VIEW_USERS;
    } catch (Exception e) {
      logger.error("Error encountered while getting users. Error is:");
      e.printStackTrace();
      return ERROR_PAGE;
    }
  }

  @RequestMapping(value="/cities", method= RequestMethod.GET)
  public String cities(ModelMap model){
    try {
      logger.info("Cities page visited");
      model.addAttribute("cities",buildCitiesList());
      return VIEW_CITIES;
    } catch (Exception e) {
      logger.error("Error encountered while getting cities. Error is:");
      e.printStackTrace();
      return ERROR_PAGE;
    }
  }

  //todo:create cities table and dao for hibernate persistence POC
  private List<City> buildCitiesList(){
	  City a = new City("Kabul","AFG","Kabol",1780000L);
	  City b = new City("Qandahar","AFG","Qandahar",237500L);
	  return Arrays.asList(new City[] {a,b});
  }
}
