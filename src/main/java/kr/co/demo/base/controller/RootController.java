package kr.co.demo.base.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import kr.co.demo.base.common.util.Pagination;
import kr.co.demo.base.domain.Product;
import kr.co.demo.base.domain.User;
import kr.co.demo.base.service.RootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@Slf4j
public class RootController {
    @Autowired
    RootService rootService;

    ModelAndView modelAndView = new ModelAndView();
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
    public ModelAndView registerPage(){
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
    public ModelAndView redirect(){
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @ResponseBody
    @PostMapping(value = "/member/email/{email}")
    public String emailCheck(@PathVariable(value = "email") String email){
        return rootService.checkEmail(email) ? "email-check-success" : "email-check-fail";
    }

    @GetMapping(value = {"/product/list", "/product/list/{currentPage}"})
    public ModelAndView productBoard(@PathVariable(required = false, name = "currentPage") Integer currentPage){
        int pageCount = rootService.productCount();

        Pagination pagination = new Pagination(pageCount, (currentPage != null) ? currentPage: 1);
        System.out.println(pagination);
        List<Product> productList = rootService.productList(pagination.getPageSize(), pagination.getStartIndex());

        modelAndView.addObject("productList", productList);
        modelAndView.addObject("pagination", pagination);
        modelAndView.setViewName("product_list");
        return modelAndView;
    }
    @PostMapping(value = "/product/insert")
    public String productInsert(){
/*        for(int i = 0; i < 300; i++){
            rootService.insertProduct(new Product("상품"+i, 1000 + i, "BOOTS") );
        }*/
        return "OK";
    }

    @GetMapping(value = "/fileUpload")
    public ModelAndView fileUpload(){

        modelAndView.setViewName("file_upload");
        return modelAndView;
    }

    @PostMapping(value = "fileUpload")
    public ModelAndView fileUpload(@RequestParam MultipartFile file, @RequestParam String username) throws IOException {
        String rootUploadDir = "C:\\Users\\LMBean\\Desktop\\work";
        File dir = new File(rootUploadDir + "\\filerepository");

        if(!dir.exists()){
            dir.mkdirs();
        }

        String oriFileName = file.getOriginalFilename();

        String sysFileName;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss");
        sysFileName = simpleDateFormat.format(new Date());
        sysFileName += username;
        System.out.println("sysFileName: " + sysFileName);
        System.out.println("originalFileName: " + oriFileName);
        String[] oriFileExtension = oriFileName.split("\\.");
        for(String s: oriFileExtension){
            System.out.print(s + " , ");
        }
        File destFile = new File(dir + File.separator + sysFileName + "." + oriFileExtension[oriFileExtension.length - 1]);
        file.transferTo(destFile);

        modelAndView.addObject("systemFileName", sysFileName);
        modelAndView.addObject("originalFileName", oriFileName);
        modelAndView.setViewName("upload_redirect");
        return modelAndView;
    }

    @GetMapping(value = "/emailsend")
    public ModelAndView emailSend(){

        modelAndView.setViewName("email_send");
        return modelAndView;
    }
}
