package com.example.mhlmbackend.service;

import com.example.mhlmbackend.dto.ArmorLoadoutFormDTO;
import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.repository.ArmorLoadoutRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ArmorLoadoutServiceTest { // rewrite this test file

    @Autowired
    private ArmorLoadoutService armorLoadoutService;

    @Autowired
    private ArmorLoadoutRepository armorLoadoutRepository;

    @Test
    void getAllArmorLoadoutsReturnsData() {
        List<ArmorLoadout> armorLoadouts = armorLoadoutService.getAllArmorLoadouts();

        assertFalse(armorLoadouts.isEmpty());
    }

    @Test
    void getArmorLoadoutByIdReturnsCorrectArmorLoadout() {
        ArmorLoadout armorLoadout = armorLoadoutService.getArmorLoadoutById("1");
        assertNotNull(armorLoadout);
        assertEquals("1", String.valueOf(armorLoadout.getId()));
    }

    @Test
    @Transactional
    void createArmorLoadoutPersistsToDb() {
        // head, chest, gloves, waist, legs
        ArmorPiece head = new ArmorPiece();
        ArmorPiece chest = new ArmorPiece();
        ArmorPiece gloves = new ArmorPiece();
        ArmorPiece waist = new ArmorPiece();
        ArmorPiece legs = new ArmorPiece();

        ArmorLoadoutFormDTO form = new ArmorLoadoutFormDTO(
                "test",
                head,
                chest,
                gloves,
                waist,
                legs
        );

        ArmorLoadout saved =  armorLoadoutService.createArmorLoadout(form);

        assertNotNull(saved.getId());
        assertTrue(armorLoadoutRepository.findById(saved.getId()).isPresent());
        assertEquals("test", saved.getName());
    }
}