package com.example.mhlmbackend.service;

import com.example.mhlmbackend.model.ArmorPiece;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ArmorPieceServiceTest {

    @Autowired
    ArmorPieceService armorPieceService;

    @Test
    void getAllArmorPiecesReturnsData() {
        List<ArmorPiece> armorPieces = armorPieceService.getAllArmorPieces();
        assertFalse(armorPieces.isEmpty());
    }

    @Test
    void getArmorPieceByIdReturnsCorrectArmorPiece() {
        ArmorPiece armorPiece = armorPieceService.getArmorPieceById("1");
        assertNotNull(armorPiece);
        assertEquals("1", armorPiece.getId());
    }

    @Test
    void getArmorPieceByTypeReturnsCorrectArmorPiece() {
        List<ArmorPiece> headEquipment = armorPieceService.getArmorPiecesByType("head");

        for (ArmorPiece armorPiece : headEquipment) {
            assertEquals("head", armorPiece.getType());
        }

        List<ArmorPiece> chestEquipment = armorPieceService.getArmorPiecesByType("chest");

        for (ArmorPiece armorPiece : chestEquipment) {
            assertEquals("chest", armorPiece.getType());
        }

        List<ArmorPiece> glovesEquipment = armorPieceService.getArmorPiecesByType("gloves");

        for (ArmorPiece armorPiece : glovesEquipment) {
            assertEquals("gloves", armorPiece.getType());
        }
        List<ArmorPiece> waistEquipment = armorPieceService.getArmorPiecesByType("waist");

        for (ArmorPiece armorPiece : waistEquipment) {
            assertEquals("waist", armorPiece.getType());
        }
        List<ArmorPiece> legsEquipment = armorPieceService.getArmorPiecesByType("legs");

        for (ArmorPiece armorPiece : legsEquipment) {
            assertEquals("legs", armorPiece.getType());
        }
    }
}
