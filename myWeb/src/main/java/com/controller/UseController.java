package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UseController {
    @RequestMapping(value = "/quick4")
//    spring自动帮你注入
    public String save4(Model m){
        m.addAttribute("username","chill123");
        return "index";
    }

    @RequestMapping(value = "/quick3")
//    spring自动帮你注入
    public ModelAndView save3(ModelAndView mv){
        mv.addObject("username","loli");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username","lolichill");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/quick")
    public String save(){
        System.out.println("save....");
        return "index";
    }
}
