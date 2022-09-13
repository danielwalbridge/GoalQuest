package com.webbApp.GoalQuest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap model) {
        return "loginPage";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String goToCreateUser(ModelMap model) {
        return "createUser";
    }

    //TODO update background color on all pages.
//TODO figure out how to create a user and map it to the DATABASE from the create user screen
    //TODO change over app to grab users from database instead of inmemory



}
