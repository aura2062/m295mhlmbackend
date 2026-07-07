package com.example.mhlmbackend.repository;

import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.model.ArmorPiece;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArmorLoadoutRepositoryTest {

    @Autowired
    private ArmorLoadoutRepository armorLoadoutRepository;

    @Autowired
    private ArmorPieceRepository armorPieceRepository;

    @Test
    @Transactional
    void seederHasDbFilledWithAtLeastOneValidArmorLoadout() {
        assertTrue(armorPieceRepository.findAll().size()>5);
        String name = "test-loadout";
        ArmorPiece head = armorPieceRepository.findById("1").orElse(null);
        ArmorPiece chest = armorPieceRepository.findById("2").orElse(null);
        ArmorPiece gloves = armorPieceRepository.findById("3").orElse(null);
        ArmorPiece waist = armorPieceRepository.findById("4").orElse(null);
        ArmorPiece legs = armorPieceRepository.findById("5").orElse(null);

        assertNotNull(head);
        assertNotNull(chest);
        assertNotNull(gloves);
        assertNotNull(waist);
        assertNotNull(legs);

        ArmorLoadout armorLoadout = new ArmorLoadout( name, head, chest, gloves, waist, legs );

        armorLoadoutRepository.save(armorLoadout);

        List<ArmorLoadout> listOfSavedLoadouts = armorLoadoutRepository.findAll();

        ArmorLoadout foundCorrectArmorLoadoutInRepository = new ArmorLoadout();

        for (ArmorLoadout loadout : listOfSavedLoadouts) {
            if (loadout.getName().equals(name)) {
                foundCorrectArmorLoadoutInRepository = loadout;
            }
        }

        assertEquals(foundCorrectArmorLoadoutInRepository.getHeadArmorPiece().getName(), head.getName());
        assertEquals(foundCorrectArmorLoadoutInRepository.getChestArmorPiece().getName(), chest.getName());
        assertEquals(foundCorrectArmorLoadoutInRepository.getGlovesArmorPiece().getName(), gloves.getName());
        assertEquals(foundCorrectArmorLoadoutInRepository.getWaistArmorPiece().getName(), waist.getName());
        assertEquals(foundCorrectArmorLoadoutInRepository.getLegsArmorPiece().getName(), legs.getName());
        assertTrue(foundCorrectArmorLoadoutInRepository.getId() >= 0);
    }
}
