package com.spring.security.test.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser() {
        return ResponseEntity.ok("i am normal user");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicUser() {
        return ResponseEntity.ok("i am public user");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('NORMAL','ADMIN')")
    public ResponseEntity<String> adminUser() {
        return ResponseEntity.ok("i am Admin user");
    }

}
