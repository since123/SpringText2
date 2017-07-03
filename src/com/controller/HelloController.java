package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/18.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Object hello() {
        return "book";
    }
}
