/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.interfaces;

import com.ads.beans.User;
import java.util.List;

/**
 *
 * @author Rahul
 */
public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public User getUserById(String id);
    public void updateUser(User user);
    public void deleteUser(String userId);
}
