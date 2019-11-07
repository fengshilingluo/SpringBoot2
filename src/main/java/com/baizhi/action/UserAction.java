package com.baizhi.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//sadasdasd
//wwwwwwwwww
@Controller
@RequestMapping("/user")
public class UserAction {
    @RequestMapping("/u1")
    public String u1() throws Exception {
        System.out.println("Hello JSP asdas");
        return "index";
    }


    @RequestMapping("/u2")
    public String u2() throws Exception {
        System.out.println("Hello  asdas");
        return "index";
    }

    @RequestMapping("/u3")
    public String u3() throws Exception {
        System.out.println("Hello JSP");
        return "index";
    }
}
