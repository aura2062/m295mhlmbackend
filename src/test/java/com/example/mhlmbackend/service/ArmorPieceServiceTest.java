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
}
