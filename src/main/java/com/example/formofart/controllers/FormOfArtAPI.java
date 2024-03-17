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


//a web api for music
@RestController
@RequestMapping("api/v1/music")
@CrossOrigin(origins = "*")
public class FormOfArtAPI {

    private MusicService service;

    public FormOfArtAPI(MusicService service)
    {
        this.service = service;
    }

    //get
    @GetMapping("all")
    public ResponseEntity<List<Music>> all()
    {
        return new ResponseEntity<>(service.all(), HttpStatus.OK);
    }

    @GetMapping("title/{title}")
    public ResponseEntity<Music> byTitle(@PathVariable String title)
    {
        return new ResponseEntity<>(service.byTitle(title), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Music> byId(@PathVariable int id)
    {
        Music music = service.byId(id);
        if (music == null)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity(music, HttpStatus.OK);
        }
    }

    @GetMapping("year/{year}")
    public ResponseEntity<List<Music>> byYear(@PathVariable int year)
    {
        return new ResponseEntity(service.byYear(year), HttpStatus.OK);
    }


    //post
    @PostMapping("")
    public ResponseEntity addMusic(@RequestBody Music newMusic)
    {
        return new ResponseEntity(service.addMusic(newMusic),
                HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id,
                                             @RequestBody Music updatedMusic)
    {
        Music music = service.byId(id);
        if (music == null)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity(service.updateMusic(updatedMusic, id),
                    HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteMusic(@PathVariable int id)
    {
        Music music = service.byId(id);
        if (music == null)
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
            service.deleteMusic(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}
