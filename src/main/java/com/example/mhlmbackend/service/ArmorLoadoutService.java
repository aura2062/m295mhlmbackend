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

    public List<ArmorLoadout> getAllArmorLoadouts() {
        return armorLoadoutRepository.findAll();
    }

    public ArmorLoadout getArmorLoadoutById(String id) {
        return armorLoadoutRepository.findById(id).orElse(null);
    }
}
