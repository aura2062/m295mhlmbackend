package com.example.mhlmbackend.service;

import com.example.mhlmbackend.model.ArmorLoadout;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ArmorLoadoutServiceTest {

    @Autowired
    private ArmorLoadoutService armorLoadoutService;

    @Test
    void getAllArmorLoadoutsReturnsData() {
        List<ArmorLoadout> armorLoadouts = armorLoadoutService.getAllArmorLoadouts();

        assertFalse(armorLoadouts.isEmpty());
    }

    @Test
    void getArmorLoadoutByIdReturnsCorrectArmorLoadout() {
        assertTrue(true);} // implement later with @Transactional that I saw in one of the google classroom blocks
}