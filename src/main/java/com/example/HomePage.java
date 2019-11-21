package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {
    @GetMapping("/version")
    String versionMethod()
    {
        return "the version is 1.3";
    }

    public String version(String abc) {
        return abc;
    }
}
