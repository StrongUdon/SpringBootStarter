package kr.co.demo.base.controller;

import kr.co.demo.base.domain.api.ChatResponse;
import kr.co.demo.base.domain.api.User;
import kr.co.demo.base.service.RootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@Slf4j
public class RootController {
    @Autowired
    RootService rootService;

    @GetMapping(value = "/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping(value = "/login")
    public ModelAndView login(@RequestBody User user, ModelAndView modelAndView){
        if(rootService.loginCheck(user)){
            modelAndView.setViewName("/");
            modelAndView.addObject("user", user);
        } else{
            modelAndView.setViewName("/login");




        }

        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerPage(ModelAndView modelAndView){
        modelAndView.setViewName("register");

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User user){
        String response;
        if(rootService.insertUser(user) == true){
            response = "register-success";
        } else {
            response = "register-error";
        }
        return response;
    }

    @GetMapping(value = "/redirect")
    public ModelAndView redirect(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @ResponseBody
    @PostMapping(value = "/member/email/{email}")
    public String emailCheck(@PathVariable(value = "email") String email){
        return rootService.checkEmail(email) ? "email-check-success" : "email-check-fail";
    }
}
