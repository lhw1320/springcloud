package com.qdfae.feign_consumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qdfae.feign_consumer1.api.DcApi;

@RestController
public class DcController {
	
    @Autowired
    private DcApi dcApi;
    
    @GetMapping("/consumer")
    public String dc() {
        return dcApi.consumer();
    }
    
}