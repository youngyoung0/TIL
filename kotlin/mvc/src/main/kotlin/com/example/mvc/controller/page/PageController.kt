package com.example.mvc.controller.page

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    @GetMapping("/main")
    fun main(): String{ // text "main.html"
        println("init main")
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test")
    fun response(): String{
        return "main.html";
    }
}