package com.cloudwise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Enzo
 * @version : 1.0
 * @date : Created on 2020/12/14 11:52
 * @description :
 * @modifiedBy :
 */
@Controller
@RequestMapping("GotoController")
public class GotoController {
    @GetMapping("toShowPerson")
    public String toShowPerson() {
        return "showPerson";
    }
}
