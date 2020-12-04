package kr.co.demo.base.controller;

import kr.co.demo.base.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RootController {

    @Autowired
    RootService rootService;
    @GetMapping(value = "/")
    public ModelAndView home(ModelAndView modelAndView){

        modelAndView.setViewName("index");
        return modelAndView;
    }
}
