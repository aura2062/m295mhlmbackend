package com.example.mhlmbackend.controller;

import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.service.ArmorLoadoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArmorLoadoutController {

    private final ArmorLoadoutService armorLoadoutService;

    public ArmorLoadoutController(ArmorLoadoutService armorLoadoutService) {
        this.armorLoadoutService = armorLoadoutService;
    }

    @GetMapping("/api/armorloadouts")
    public List<ArmorLoadout> getArmorLoadouts() {
        return armorLoadoutService.getAllArmorLoadouts();
    }

    @GetMapping("/api/armorloadouts/{id}")
    public ArmorLoadout getArmorLoadoutById(@PathVariable String id) {
        return armorLoadoutService.getArmorLoadoutById(id);
    }
}
