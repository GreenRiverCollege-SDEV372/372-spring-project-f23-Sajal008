package com.example.formofart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String style;
    private int difficultyLevel;
    private boolean popular;
    private String origin;

    }

