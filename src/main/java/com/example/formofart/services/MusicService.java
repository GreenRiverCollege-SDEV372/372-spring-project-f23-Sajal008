package com.example.formofart.services;

import com.example.formofart.db.MusicRepository;
import com.example.formofart.models.Music;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;

@Service
public class MusicService {

    private MusicRepository repository;

    public MusicService(MusicRepository repository)
    {
        this.repository = repository;
    }

    public List<Music> all()
    {
        List<Music> movies = repository.findAll();
        return Collections.unmodifiableList(movies);
    }

    public Music addMusic(Music music)
    {
        //this will result in an INSERT SQL statement
        return repository.save(music);
    }
}
