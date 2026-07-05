package com.example.mhlmbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArmorPieceController {

    public List<ArmorPiece> armorPieces = List.of(
            new ArmorPiece("1", "Leather Headgear", "head"),
            new ArmorPiece("2", "Leather Mail", "chest"),
            new ArmorPiece("3", "Leather Gloves", "gloves"),
            new ArmorPiece("4", "Leather Belt", "waist"),
            new ArmorPiece("5", "Leather Trousers", "legs")
    );

    @GetMapping("/api/armorpieces")
    public List<ArmorPiece> getArmorPieces() {
        return armorPieces;
    }

    @GetMapping("/api/armorpieces/{id}")
    public ArmorPiece getArmorPieceById( @PathVariable String id) {
        for (ArmorPiece armorPiece : armorPieces) {
            if (armorPiece.getId().equals(id)) {
                return armorPiece;
            }
        };
        return null;
    }
}
