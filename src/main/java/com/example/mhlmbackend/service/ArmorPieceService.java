package com.example.mhlmbackend.service;

import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.repository.ArmorPieceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ArmorPieceService {

    private final ArmorPieceRepository armorPieceRepository;

    public ArmorPieceService(ArmorPieceRepository armorPieceRepository) {
        this.armorPieceRepository = armorPieceRepository;
    }

    // READ
    public List<ArmorPiece> getAllArmorPieces() {
        return armorPieceRepository.findAll();
    }

    public ArmorPiece getArmorPieceById( @PathVariable String id) {
        return armorPieceRepository.findById(id).orElse(null);
    }
}