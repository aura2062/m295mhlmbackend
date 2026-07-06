package com.example.mhlmbackend.repository;

import com.example.mhlmbackend.model.ArmorLoadout;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ArmorLoadoutRepositoryTest {

    @Autowired
    private ArmorLoadoutRepository armorLoadoutRepository;

    @Test
    void seederHasDbFilledWithAtLeastOneArmorLoadout() {
        long count =  armorLoadoutRepository.count();

        assertTrue(count > 0);
    }
}
