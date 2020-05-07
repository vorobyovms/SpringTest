/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mihail
 */
@RestController
@RequestMapping("/home")

public class TestInfo {

    //весь персонал
    @RequestMapping("/test1")
    String Answers() {
        return "OK--1";
    }

    @RequestMapping("/test2")
    public class TestInfo1 {
        @GetMapping("/test2/s2")
        String GetRes() {
            return "URA";
        }
    }
}
