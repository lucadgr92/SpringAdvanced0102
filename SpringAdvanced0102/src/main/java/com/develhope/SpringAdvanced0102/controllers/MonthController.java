package com.develhope.SpringAdvanced0102.controllers;


import com.develhope.SpringAdvanced0102.entities.MonthEntity;
import com.develhope.SpringAdvanced0102.services.MonthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/month")
public class MonthController {

    @Autowired
    private MonthService service;

    @GetMapping("/show")
    public @ResponseBody MonthEntity showMonth(HttpServletRequest request) {
        return (MonthEntity) request.getAttribute("monthNumber");
    }

    @PostMapping("/create")
    public @ResponseBody MonthEntity addMonth(@RequestBody MonthEntity month) {
        return service.addMonth(month);
    }
}

