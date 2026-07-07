package com.example.mhlmbackend.repository;

import com.example.mhlmbackend.model.ArmorPiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArmorPieceRepository extends JpaRepository<ArmorPiece, String> {
    List<ArmorPiece> findByType(String type);
}
