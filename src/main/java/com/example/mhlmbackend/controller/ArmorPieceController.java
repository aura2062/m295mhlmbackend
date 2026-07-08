package com.example.mhlmbackend.controller;

import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.service.ArmorPieceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/armorpieces")
public class ArmorPieceController {

    private final ArmorPieceService armorPieceService;

    public  ArmorPieceController(ArmorPieceService armorPieceService) {
        this.armorPieceService = armorPieceService;
    }

    @GetMapping
    public List<ArmorPiece> getArmorPieces() {
        return armorPieceService.getAllArmorPieces();
    }

    @GetMapping("/{id}")
    public ArmorPiece getArmorPieceById( @PathVariable String id) {
        return armorPieceService.getArmorPieceById(id);
    }

    @GetMapping("/type/{type}")
    public List<ArmorPiece> getArmorPiecesByType(@PathVariable String type) {
        return armorPieceService.getArmorPiecesByType(type);
    }
}
