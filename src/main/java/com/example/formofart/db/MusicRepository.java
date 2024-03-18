package com.example.formofart.db;
import com.example.formofart.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//db
@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>
{

}
