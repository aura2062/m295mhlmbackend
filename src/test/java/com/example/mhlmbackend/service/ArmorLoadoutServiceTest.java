package com.example.mhlmbackend.service;

import com.example.mhlmbackend.dto.ArmorLoadoutFormDTO;
import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.repository.ArmorLoadoutRepository;
import com.example.mhlmbackend.repository.ArmorPieceRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArmorLoadoutServiceTest {

    @Autowired
    private ArmorLoadoutService armorLoadoutService;

    @Autowired
    private ArmorPieceRepository armorPieceRepository;

    @Test
    @Transactional
    void getAllArmorLoadoutsReturnsCorrectData() {
        assertTrue(armorPieceRepository.findAll().size()>5);
        String name = "test-loadout v2";
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

        ArmorLoadoutFormDTO form = new ArmorLoadoutFormDTO(name, head, chest, gloves, waist, legs);
        ArmorLoadout toBeCreatedLoadout = armorLoadoutService.createArmorLoadout(form);

        List<ArmorLoadout> listOfSavedLoadouts = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout foundCorrectArmorLoadout= new ArmorLoadout();

        for (ArmorLoadout loadout : listOfSavedLoadouts) {
            if (loadout.getId().equals(toBeCreatedLoadout.getId())) {
                foundCorrectArmorLoadout = loadout;
            }
        }

        assertEquals(foundCorrectArmorLoadout.getHeadArmorPiece().getName(), head.getName());
        assertEquals(foundCorrectArmorLoadout.getChestArmorPiece().getName(), chest.getName());
        assertEquals(foundCorrectArmorLoadout.getGlovesArmorPiece().getName(), gloves.getName());
        assertEquals(foundCorrectArmorLoadout.getWaistArmorPiece().getName(), waist.getName());
        assertEquals(foundCorrectArmorLoadout.getLegsArmorPiece().getName(), legs.getName());
        assertTrue(foundCorrectArmorLoadout.getId() >= 0);
    }

    @Test
    @Transactional
    void getArmorLoadoutByIdReturnsCorrectData() {
        assertTrue(armorPieceRepository.findAll().size()>5);
        String name = "test-loadout v3";
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

        ArmorLoadoutFormDTO form = new ArmorLoadoutFormDTO(name, head, chest, gloves, waist, legs);
        ArmorLoadout toBeCreatedLoadout = armorLoadoutService.createArmorLoadout(form);

        List<ArmorLoadout> listOfSavedLoadouts = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout foundCorrectArmorLoadout= new ArmorLoadout();

        for (ArmorLoadout loadout : listOfSavedLoadouts) {
            if (loadout.getId().equals(toBeCreatedLoadout.getId())) {
                foundCorrectArmorLoadout = loadout;
            }
        }

        long correctId =  foundCorrectArmorLoadout.getId();

        ArmorLoadout finalArmorLoadout = armorLoadoutService.getArmorLoadoutById(String.valueOf(correctId));

        assertEquals(finalArmorLoadout.getHeadArmorPiece().getName(), head.getName());
        assertEquals(finalArmorLoadout.getChestArmorPiece().getName(), chest.getName());
        assertEquals(finalArmorLoadout.getGlovesArmorPiece().getName(), gloves.getName());
        assertEquals(finalArmorLoadout.getWaistArmorPiece().getName(), waist.getName());
        assertEquals(finalArmorLoadout.getLegsArmorPiece().getName(), legs.getName());
        assertEquals((long) finalArmorLoadout.getId(), correctId);
    }

    @Test
    @Transactional
    void createArmorLoadoutPersistsToDb() {
        assertTrue(armorPieceRepository.findAll().size()>5);
        String name = "test-loadout v4";
        ArmorPiece head = armorPieceRepository.findById("1").orElse(null);
        ArmorPiece chest = armorPieceRepository.findById("2").orElse(null);
        ArmorPiece gloves = armorPieceRepository.findById("3").orElse(null);
        ArmorPiece waist = armorPieceRepository.findById("4").orElse(null);
        ArmorPiece legs = armorPieceRepository.findById("5").orElse(null);

        ArmorLoadoutFormDTO form = new ArmorLoadoutFormDTO(
                name,
                head,
                chest,
                gloves,
                waist,
                legs
        );

        ArmorLoadout saved = armorLoadoutService.createArmorLoadout(form);

        List<ArmorLoadout> listOfSavedLoadouts = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout foundCorrectArmorLoadout= new ArmorLoadout();
        for (ArmorLoadout loadout : listOfSavedLoadouts) {
            if (loadout.getId().equals(saved.getId())) {
                foundCorrectArmorLoadout = loadout;
            }
        }

        assertNotNull(foundCorrectArmorLoadout.getId());
        assertEquals(name, foundCorrectArmorLoadout.getName());
        assertEquals(foundCorrectArmorLoadout.getHeadArmorPiece().getName(), head.getName());
        assertEquals(foundCorrectArmorLoadout.getChestArmorPiece().getName(), chest.getName());
        assertEquals(foundCorrectArmorLoadout.getGlovesArmorPiece().getName(), gloves.getName());
        assertEquals(foundCorrectArmorLoadout.getWaistArmorPiece().getName(), waist.getName());
        assertEquals(foundCorrectArmorLoadout.getLegsArmorPiece().getName(), legs.getName());
    }

    @Test
    @Transactional
    void updateArmorLoadoutUpdatesCorrectly() {
        assertTrue(armorPieceRepository.findAll().size()>5);
        String name = "test-loadout v5";
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

        ArmorLoadoutFormDTO form = new ArmorLoadoutFormDTO(name, head, chest, gloves, waist, legs);
        ArmorLoadout toBeCreatedLoadout = armorLoadoutService.createArmorLoadout(form);

        List<ArmorLoadout> listOfSavedLoadouts = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout foundCorrectArmorLoadout= new ArmorLoadout();

        for (ArmorLoadout loadout : listOfSavedLoadouts) {
            if (loadout.getId().equals(toBeCreatedLoadout.getId())) {
                foundCorrectArmorLoadout = loadout;
            }
        }

        long correctId =  foundCorrectArmorLoadout.getId();

        String name2 = "test-loadout v6";
        ArmorPiece head2 = armorPieceRepository.findById("6").orElse(null);
        ArmorPiece chest2 = armorPieceRepository.findById("7").orElse(null);
        ArmorPiece gloves2 = armorPieceRepository.findById("8").orElse(null);
        ArmorPiece waist2 = armorPieceRepository.findById("9").orElse(null);
        ArmorPiece legs2 = armorPieceRepository.findById("10").orElse(null);

        ArmorLoadoutFormDTO updatedForm = new ArmorLoadoutFormDTO(name2, head2, chest2, gloves2, waist2, legs2);
        armorLoadoutService.updateArmorLoadout(String.valueOf(correctId), updatedForm);

        List<ArmorLoadout> listWithUpdatedLoadout = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout foundUpdatedLoadout = null;

        for (ArmorLoadout loadout : listWithUpdatedLoadout) {
            if (loadout.getId().equals(toBeCreatedLoadout.getId())) {
                foundUpdatedLoadout = loadout;
            }
        }

        assertNotNull(foundUpdatedLoadout);
        assertEquals(name2, foundUpdatedLoadout.getName());
        assertEquals(foundUpdatedLoadout.getHeadArmorPiece().getName(), head2.getName());
        assertEquals(foundUpdatedLoadout.getChestArmorPiece().getName(), chest2.getName());
        assertEquals(foundUpdatedLoadout.getGlovesArmorPiece().getName(), gloves2.getName());
        assertEquals(foundUpdatedLoadout.getWaistArmorPiece().getName(), waist2.getName());
        assertEquals(foundUpdatedLoadout.getLegsArmorPiece().getName(), legs2.getName());
        assertEquals((long) foundUpdatedLoadout.getId(), correctId);
    }

    @Test
    @Transactional
    void deleteArmorLoadoutReturnsDeletesCorrectly() {
        assertTrue(armorPieceRepository.findAll().size()>5);
        String name = "test-loadout v7";
        ArmorPiece head = armorPieceRepository.findById("1").orElse(null);
        ArmorPiece chest = armorPieceRepository.findById("2").orElse(null);
        ArmorPiece gloves = armorPieceRepository.findById("3").orElse(null);
        ArmorPiece waist = armorPieceRepository.findById("4").orElse(null);
        ArmorPiece legs = armorPieceRepository.findById("5").orElse(null);

        ArmorLoadoutFormDTO form = new ArmorLoadoutFormDTO(
                name,
                head,
                chest,
                gloves,
                waist,
                legs
        );

        ArmorLoadout saved = armorLoadoutService.createArmorLoadout(form);

        List<ArmorLoadout> listOfSavedLoadouts = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout foundCorrectArmorLoadout= new ArmorLoadout();
        for (ArmorLoadout loadout : listOfSavedLoadouts) {
            if (loadout.getId().equals(saved.getId())) {
                foundCorrectArmorLoadout = loadout;
            }
        }

        armorLoadoutService.deleteArmorLoadout(String.valueOf(foundCorrectArmorLoadout.getId()));

        List<ArmorLoadout> listOfAllLoadouts = armorLoadoutService.getAllArmorLoadouts();

        ArmorLoadout doesItStillExist = null;

        for (ArmorLoadout loadout : listOfAllLoadouts) {
            if (loadout.getId().equals(saved.getId())) {
                doesItStillExist = loadout;
            }
        }

        assertNull(doesItStillExist);
    }
}