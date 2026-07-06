package com.example.mhlmbackend.service;

import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.repository.ArmorLoadoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmorLoadoutService {

    private final ArmorLoadoutRepository armorLoadoutRepository;

    public ArmorLoadoutService(ArmorLoadoutRepository armorLoadoutRepository) {
        this.armorLoadoutRepository = armorLoadoutRepository;
    }

    // CREATE
    public ArmorLoadout createArmorLoadout(ArmorLoadout armorLoadout) {
        return armorLoadoutRepository.save(armorLoadout);
    }

    // READ
    public List<ArmorLoadout> getAllArmorLoadouts() {
        return armorLoadoutRepository.findAll();
    }

    public ArmorLoadout getArmorLoadoutById(String id) {
        return armorLoadoutRepository.findById(Long.parseLong(id)).orElse(null);
    }

    // UPDATE
    public ArmorLoadout updateArmorLoadout(String id, ArmorLoadout armorLoadout) {
        armorLoadout.setId(Long.parseLong(id));
        return armorLoadoutRepository.save(armorLoadout);
    }

    // DELETE
    public void deleteArmorLoadout(String id) {
        armorLoadoutRepository.deleteById(Long.parseLong(id));
    }
}
