package com.example.mhlmbackend.service;

import com.example.mhlmbackend.dto.ArmorLoadoutFormDTO;
import com.example.mhlmbackend.exception.ArmorLoadoutNotFoundException;
import com.example.mhlmbackend.mapper.ArmorLoadoutMapper;
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
    public ArmorLoadout createArmorLoadout(ArmorLoadoutFormDTO form) {
        ArmorLoadout armorLoadout = ArmorLoadoutMapper.toEntity(form);

        return armorLoadoutRepository.save(armorLoadout);
    }

    // READ
    public List<ArmorLoadout> getAllArmorLoadouts() {
        return armorLoadoutRepository.findAll();
    }

    public ArmorLoadout getArmorLoadoutById(String id) {
        return armorLoadoutRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ArmorLoadoutNotFoundException(id) );
    }

    // UPDATE
    public ArmorLoadout updateArmorLoadout(String id, ArmorLoadoutFormDTO form) {
        if(!armorLoadoutRepository.existsById(Long.parseLong(id))) {
            throw new ArmorLoadoutNotFoundException(id);
        }

        ArmorLoadout armorLoadout = ArmorLoadoutMapper.toEntity(form);
        armorLoadout.setId(Long.parseLong(id));
        return armorLoadoutRepository.save(armorLoadout);
    }

    // DELETE
    public void deleteArmorLoadout(String id) {
        if(!armorLoadoutRepository.existsById(Long.parseLong(id))) {
            throw new ArmorLoadoutNotFoundException(id);
        }

        armorLoadoutRepository.deleteById(Long.parseLong(id));
    }
}
