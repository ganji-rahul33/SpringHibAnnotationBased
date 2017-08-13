/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.demo;

import com.ads.beans.User;
import com.ads.interfaces.UserService;
import com.ads.interfaces.impl.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Rahul
 */
@Controller
@Scope("request")
public class UsersController {
    
    static  org.apache.log4j.Logger logger =  org.apache.log4j.Logger.getLogger(UsersController.class );
    @Autowired(required = true)
    @Qualifier("userFormVal")
    private Validator validator;

    @Autowired(required = true)    
    private UserService userService;
    
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    
//    @Autowired(required = true)
////    @Qualifier("employee")
//    public Employee employee;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("loginUserForm")
    public ModelAndView loginUserForm() {
        return new ModelAndView("loginUserForm", "User", new User());
    }
    
    @RequestMapping(value = "userAuth",method = RequestMethod.POST, params = "addUser")
    public ModelAndView addUser() {
        return new ModelAndView("addUserForm", "User", new User());
    }

    
    @RequestMapping(value = "userAuth",method = RequestMethod.POST, params = "authUser")
    public String authUser(@ModelAttribute("User") @Validated User login, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("User", login);
            return "loginUserForm" ;
        }
        return "redirect:/users";
    }
    
    
    @RequestMapping(value = "userForm")
    public ModelAndView userForm() {
        User loginForm = new User();
        return new ModelAndView("addUserForm", "User", loginForm);
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST, params = "addUser")
    public String saveUser(@ModelAttribute("User") @Validated  User login, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("User", login);
            return "addUserForm" ;
        }
        userService.addUser(login);
        return "redirect:/users";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, params = "loginForm")
    public ModelAndView showUsers() {
        return new ModelAndView("redirect:/loginUserForm");
    }

    @RequestMapping("users")
    public ModelAndView usersList() {
//        logger.info("--------------------name:"+this.employee.getName());
        return new ModelAndView("viewUsers", "users", userService.getAllUsers());
    }

    @RequestMapping("editUser/{userId}")
    public ModelAndView editUser(@PathVariable String userId, @ModelAttribute("User") User user, BindingResult result) {
        return new ModelAndView("editUserDetails", "User", userService.getUserById(userId));
    }

    @RequestMapping(value = "/updateForm", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("User") @Validated User login, BindingResult result, ModelMap modelMap, HttpServletRequest request) {
        String updateUser = request.getParameter("updateUser");
        if (updateUser != null && !"".equals(updateUser)) {
            if(result.hasErrors()) {
                return new ModelAndView("editUserDetails", "User", login);
            }
            userService.updateUser(login);
        }
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "deleteUser/{userId}")
    public ModelAndView deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ModelAndView("redirect:/users");
    }


}
