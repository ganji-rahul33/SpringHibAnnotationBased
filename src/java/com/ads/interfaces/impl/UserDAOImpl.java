/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.interfaces.impl;
import com.ads.beans.User;
import com.ads.demo.*;
import com.ads.interfaces.UserDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Rahul
 */
//@Component("userDAOImpl")
@Repository
@Scope("singleton")
public class UserDAOImpl implements UserDAO{

    public UserDAOImpl() {
        System.out.println("UserDAOImpl created..");
    }
    
    @Override
    public void updateUser(User user) {
        Session hsession = HibernateSessionFactory.getSession();
        hsession.beginTransaction();
        hsession.update(user);
        hsession.getTransaction().commit();
        HibernateSessionFactory.closeSession();
    }
    

    @Override
    public void addUser(User user) {
        Session hsession = HibernateSessionFactory.getSession();
        hsession.beginTransaction();
        hsession.save(user);
        hsession.getTransaction().commit();
        HibernateSessionFactory.closeSession();
    }

    @Override
    public User getUserById(String id) {
        Session session = HibernateSessionFactory.getSession();
        Query query =  session.getNamedQuery("getUser");
        query.setString("id", id);
        List<User> list = query.list();
        HibernateSessionFactory.closeSession();
        return list != null && !list.isEmpty() ?  list.get(0) : null;
    }

    @Override
    public void deleteUser(String userId) {
        Session session = HibernateSessionFactory.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("deleteUser");
        query.setString("id", userId);
        int count = query.executeUpdate();
        session.getTransaction().commit();
        HibernateSessionFactory.closeSession();
        
    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateSessionFactory.getSession();
        Query query =  session.getNamedQuery("getAllUsers");
        List<User> list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }

}
