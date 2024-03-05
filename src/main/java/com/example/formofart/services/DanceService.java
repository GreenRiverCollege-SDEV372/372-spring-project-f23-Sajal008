package com.example.formofart.services;

import com.example.formofart.db.DanceRepository;
import com.example.formofart.models.Dance;
import org.springframework.stereotype.Service;
import com.example.formofart.db.MusicRepository;
import com.example.formofart.models.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service

public class DanceService {
    private DanceRepository repository;

    public DanceService(DanceRepository repository)
    {
        this.repository = repository;
    }

    public Dance getRandomMovie()
    {
        Random generator = new Random();
        List<Dance> movies = repository.findAll();
        int index = generator.nextInt(movies.size());
        return movies.get(index);
    }

}
