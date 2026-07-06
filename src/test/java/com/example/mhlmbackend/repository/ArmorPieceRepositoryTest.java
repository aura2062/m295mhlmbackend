package com.example.mhlmbackend.repository;

import com.example.mhlmbackend.model.ArmorPiece;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ArmorPieceRepositoryTest {

    @Autowired
    private ArmorPieceRepository armorPieceRepository;

    @Test
    void seederHasDbFilledWithAtLeastOneArmorPiece() {
        long count = armorPieceRepository.count();
        assertTrue(count > 0);
    }

    @Test
    void armorPieceCanBeLoaded() {
        Optional<ArmorPiece> armorPiece = armorPieceRepository.findById("1");
        assertTrue(armorPiece.isPresent());
    }
}
