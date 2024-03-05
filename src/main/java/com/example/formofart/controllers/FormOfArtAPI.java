package com.example.formofart.controllers;

import com.example.formofart.models.Music;
import com.example.formofart.services.MusicService;
import com.example.formofart.services.DanceService;
import com.example.formofart.models.Dance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//a web api to deliver movies...
@RestController
@RequestMapping("api/v1/movies")
@CrossOrigin(origins = "*")
public class FormOfArtAPI {

    private MusicService service;

    public FormOfArtAPI(MusicService service)
    {
        this.service = service;
    }

    @GetMapping("all")
    public ResponseEntity<List<Music>> all()
    {
        return new ResponseEntity<>(service.all(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addMovie(@RequestBody Music newMusic)
    {
        return new ResponseEntity(service.addMusic(newMusic),
                HttpStatus.CREATED);
    }


}
