package com.example.formofart.services;

import com.example.formofart.models.Music;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SpringBootApplication
public class MusicService {
    private final List<Music> musicList = new ArrayList<>();

    public List<Music> getAllMusic() {
        return musicList;
    }

    public Optional<Music> getMusicById(int id) {
        return musicList.stream().filter(music -> music.getId() == id).findFirst();
    }

    public Music createMusic(Music music) {
        // Simulating auto-increment id
        music.setId(musicList.size() + 1);
        musicList.add(music);
        return music;
    }

    public Music updateMusic(int id, Music updatedMusic) {
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getId() == id) {
                updatedMusic.setId(id);
                musicList.set(i, updatedMusic);
                return updatedMusic;
            }
        }
        return null;
    }

    public boolean deleteMusic(int id) {
        return musicList.removeIf(music -> music.getId() == id);
    }
}
