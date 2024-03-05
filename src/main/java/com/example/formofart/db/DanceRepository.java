package com.example.formofart.db;

import com.example.formofart.models.Dance;
import com.example.formofart.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceRepository extends JpaRepository<Dance, Integer>
{

}

