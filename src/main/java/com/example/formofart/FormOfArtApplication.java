package com.example.formofart;

import com.example.formofart.models.Music;
import com.example.formofart.models.Dance;
import com.example.formofart.services.MusicService;
import com.example.formofart.services.DanceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class FormOfArtApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(FormOfArtApplication.class, args);

        // Test MusicService
        MusicService musicService = context.getBean(MusicService.class);

        Music music1 = new Music("Song1", "Artist1", 2022, false);
        Music music2 = new Music("Song2", "Artist2", 2021, true);

        musicService.createMusic(music1);
        musicService.createMusic(music2);

        System.out.println("All Music: " + musicService.getAllMusic());
        Optional<Music> musicById = musicService.getMusicById(1);
        System.out.println("Music by ID 1: " + musicById.orElse(null));
        musicService.updateMusic(1, new Music("UpdatedSong", "UpdatedArtist", 2023, true));
        System.out.println("Updated Music: " + musicService.getAllMusic());
        musicService.deleteMusic(2);
        System.out.println("After deletion: " + musicService.getAllMusic());

        // Test DanceService
        DanceService danceService = context.getBean(DanceService.class);

        Dance dance1 = new Dance("Style1", 3, true, "Origin1");
        Dance dance2 = new Dance("Style2", 2, false, "Origin2");

        danceService.createDance(dance1);
        danceService.createDance(dance2);

        System.out.println("All Dances: " + danceService.getAllDances());
        Optional<Dance> danceById = danceService.getDanceById(1);
        System.out.println("Dance by ID 1: " + danceById.orElse(null));
        danceService.updateDance(1, new Dance("UpdatedStyle", 4, false, "UpdatedOrigin"));
        System.out.println("Updated Dances: " + danceService.getAllDances());
        danceService.deleteDance(2);
        System.out.println("After deletion: " + danceService.getAllDances());
    }
}
