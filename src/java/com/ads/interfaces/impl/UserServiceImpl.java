/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.interfaces.impl;

import com.ads.beans.User;
import com.ads.interfaces.UserDAO;
import com.ads.interfaces.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import sun.util.logging.resources.logging;

/**
 *
 * @author Rahul
 */

@Service
@Scope("singleton")
public class UserServiceImpl implements  UserService{

    public UserServiceImpl() {
        System.out.println("UserServiceImpl object created..");
    }

//    @Resource(name = "userDAO")
    @Autowired(required = true)
    private UserDAO userDAO;
    
    public UserDAO getUserDAO() {
        return userDAO;
    }
    
//    @Scope(value = "prototype")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    @Override
    public User getUserById(String id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        this.userDAO.deleteUser(userId);
    }
    
}
