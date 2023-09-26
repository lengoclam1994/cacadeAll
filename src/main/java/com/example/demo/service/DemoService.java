package com.example.demo.service;

import com.example.demo.entity.ComputerExposed;

import java.util.List;

public interface DemoService {

    List<ComputerExposed> find();

    void save(List<ComputerExposed> computerExposeds);
}
