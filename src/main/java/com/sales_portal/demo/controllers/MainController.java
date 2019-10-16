package com.sales_portal.demo.controllers;

import com.sales_portal.demo.DemoApplication;
import com.sales_portal.demo.data.repositories.UserRepository;
import com.sales_portal.demo.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.nio.file.Path;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private UserService userService;
    private LoginService loginService;

    //Users
    @GetMapping("userValidation")
    public String validateUser( String activationCode){
        loginService.validateUser(activationCode);
        return "login";
               }

    @GetMapping("mvc/user/register")
    public String insertUser(){
        return "register";
    }

    @PostMapping("mvc/user/register")
    public ModelAndView insertUser(String emailAddress, String password, String name){
        userService.insertUser(emailAddress, password,name);
        return home();
            }

    @GetMapping("user/{userId}/sendMail")
    public void sendMail(@PathVariable Integer userId, String subject, String content){
        userService.sendMail(userId, subject, content);

    }

    //Users

    @RequestMapping("mvc/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("index");
        return mv;
    }

    @RequestMapping("mvc/help")
    public ModelAndView help(){
        ModelAndView mv = new ModelAndView("help");
        mv.addObject("help");
        return mv;
    }






//    @RequestMapping("/mvc/greet/{userId}")
//    public String greet(Model model, @PathVariable String emailAddress){
//        model.addAttribute("userName",userService.getEmailAddress(emailAddress));
//        return "welcome";
//    }
//    @RequestMapping("mvc/user/showAll")
//    public ModelAndView greet(){
//        ModelAndView mv = new ModelAndView("users");
//        mv.addObject("users", userService.getAllUsers());
//        return mv;
//    }
}