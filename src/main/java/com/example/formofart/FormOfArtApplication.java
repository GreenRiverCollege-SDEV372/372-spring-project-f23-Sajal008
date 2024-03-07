/*@author: Sajal Khadgi
        Spring boot application
        This app is about things that peeks my interest*/

package com.example.formofart;

import com.example.formofart.db.DanceRepository;
import com.example.formofart.db.MusicRepository;
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


        List<Music> music = new ArrayList<>(List.of(
                new Music(0, "Don't Go", "Deyez", 2021, true),
                new Music(0, "A-Team", "Ed Sheeran", 2018, true),
                new Music(0, "Love yourz", "J. Cole", 2009, true),
                new Music(0, "Moto Mami", "Rosalia", 2020, false)
        ));

    }
}
