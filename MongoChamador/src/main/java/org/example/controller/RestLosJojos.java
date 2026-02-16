package org.example.controller;

import org.example.model.LosJojos;
import org.example.service.LosJojosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(RestLosJojos.MAPPING)
public class RestLosJojos {
    public static final String MAPPING = "/Mongo/LosJojos";
    @Autowired
    private LosJojosService losJojosService;

    @GetMapping
    public List<LosJojos> findAll() {
        return losJojosService.findAll();
    }


    @PostMapping
    public ResponseEntity<LosJojos> create(@RequestBody LosJojos losJojos) {
        LosJojos gardado = losJojosService.save(losJojos);
        return ResponseEntity.ok(gardado);
    }


}
