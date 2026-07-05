package com.example.mhlmbackend.service;

import com.example.mhlmbackend.model.ArmorPiece;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ArmorPieceService {

    public List<ArmorPiece> getAllArmorPieces() {
        return List.of(
                new ArmorPiece("1", "Leather Headgear", "head"),
                new ArmorPiece("2", "Leather Mail", "chest"),
                new ArmorPiece("3", "Leather Gloves", "gloves"),
                new ArmorPiece("4", "Leather Belt", "waist"),
                new ArmorPiece("5", "Leather Trousers", "legs")
        );
    }

    public ArmorPiece getArmorPieceById( @PathVariable String id) {
        for (ArmorPiece armorPiece : getAllArmorPieces()) {
            if (armorPiece.getId().equals(id)) {
                return armorPiece;
            }
        };
        return null;
    }
}
