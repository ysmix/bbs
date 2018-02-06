package com.s3.bbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class RootController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Bbs";
    }
}
