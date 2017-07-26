/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.demo;

/**
 *
 * @author Rahul
 */
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;  
@Controller  
public class HelloWorldController  {  
    @RequestMapping(method = RequestMethod.GET, value = "hello")
    public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U get";  
        return new ModelAndView("hellopage", "message", message);  
        
    }
    @RequestMapping(method = RequestMethod.POST, value = "hello")
    public ModelAndView helloWorld1() {  
        String message = "HELLO SPRING MVC HOW R U post";  
        return new ModelAndView("hellopage", "message", message);  
        
    }
}  