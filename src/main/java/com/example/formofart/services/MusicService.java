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
        List<Music> music = repository.findAll();
        return Collections.unmodifiableList(music);
    }

    public Music addMusic(Music music)
    {
        //this will result in an INSERT SQL statement
        return repository.save(music);
    }

    public Music byId(int id)
    {
        return repository.findById(id).orElse(null);
    }

    public Music byTitle(String title)
    {
        List<Music> results = new ArrayList<>();
        List<Music> music = repository.findAll();

        for (int i = 0; i < music.size(); i++)
        {
            Music next = music.get(i);
            if (next.getTitle().equals(title))
            {
                return next;
            }
        }

        return null;
    }

    public List<Music> byYear(int year)
    {
        List<Music> results = new ArrayList<>();
        List<Music> music = repository.findAll();

        for (int i = 0; i < music.size(); i++)
        {
            Music next = music.get(i);
            if (next.getReleaseYear() == year)
            {
                results.add(next);
            }
        }

        return results;
    }

    public Music addMovie(Music music)
    {
        //this will result in an INSERT SQL statement
        return repository.save(music);
    }

    public Music updateMusic(Music updatedMusic, int id)
    {
        Music currentMusic = repository.findById(id).orElseThrow();

        currentMusic.setReleaseYear(updatedMusic.getReleaseYear());
        currentMusic.setTitle(updatedMusic.getTitle());

        //this is add or update
        return repository.save(currentMusic);
    }

    public void deleteMusic(int id)
    {
        repository.deleteById(id);
    }
}
