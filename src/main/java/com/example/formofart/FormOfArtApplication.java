package com.example.formofart;

import com.example.formofart.models.Music;
import com.example.formofart.models.Dance;
import com.example.formofart.services.MusicService;
import com.example.formofart.services.DanceService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
public class FormOfArtApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FormOfArtApplication.class, args);
        MusicRepository dbRepo = context.getBean(MusicRepository.class);

        List<Movie> movies = new ArrayList<>(List.of(
                new Movie(0, "Inception", 2010, "Science Fiction", "PG-13", false),

    }
}
