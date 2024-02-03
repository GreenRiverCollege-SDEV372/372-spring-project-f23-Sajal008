package com.example.formofart.services;

import com.example.formofart.models.Dance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DanceService {
    private final List<Dance> danceList = new ArrayList<>();

    public List<Dance> getAllDances() {
        return danceList;
    }

    public Optional<Dance> getDanceById(int id) {
        return danceList.stream().filter(dance -> dance.getId() == id).findFirst();
    }

    public Dance createDance(Dance dance) {
        // Simulating auto-increment id
        dance.setId(danceList.size() + 1);
        danceList.add(dance);
        return dance;
    }

    public Dance updateDance(int id, Dance updatedDance) {
        for (int i = 0; i < danceList.size(); i++) {
            if (danceList.get(i).getId() == id) {
                updatedDance.setId(id);
                danceList.set(i, updatedDance);
                return updatedDance;
            }
        }
        return null;
    }

    public boolean deleteDance(int id) {
        return danceList.removeIf(dance -> dance.getId() == id);
    }
}
