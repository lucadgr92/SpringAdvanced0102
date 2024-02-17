package com.develhope.SpringAdvanced0102.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/basic")
public class BasicController {

    @GetMapping
    public @ResponseBody String welcomeEndoint() {
        return "Welcome, dear user!";
    }


}
/*

has 2 controllers:
        BasicController that:
        welcomes the user on the root mapping
        MonthController that:
        is mapped on months
        returns a Month using a specific request attribute
		*/
