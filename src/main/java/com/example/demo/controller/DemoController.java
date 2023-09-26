package com.example.demo.controller;

import com.example.demo.entity.ComputerExposed;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/computer-exposed")
    public ResponseEntity<List<ComputerExposed>> find() {
        return ResponseEntity.ok(demoService.find());
    }

    @PostMapping("/inventory")
    public void save(@RequestBody List<ComputerExposed> computerExposeds) {
        demoService.save(computerExposeds);
    }

}
