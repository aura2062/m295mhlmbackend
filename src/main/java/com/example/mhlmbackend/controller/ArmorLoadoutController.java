package com.example.mhlmbackend.controller;

import com.example.mhlmbackend.dto.ArmorLoadoutFormDTO;
import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.service.ArmorLoadoutService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArmorLoadoutController {

    private final ArmorLoadoutService armorLoadoutService;

    public ArmorLoadoutController(ArmorLoadoutService armorLoadoutService) {
        this.armorLoadoutService = armorLoadoutService;
    }

    // CREATE
    @PostMapping("/api/armorloadouts")
    @ResponseStatus(HttpStatus.CREATED)
    public ArmorLoadout createArmorLoadout(@Valid @RequestBody ArmorLoadoutFormDTO form) {
        return armorLoadoutService.createArmorLoadout(form);
    }

    // READ
    @GetMapping("/api/armorloadouts")
    public List<ArmorLoadout> getArmorLoadouts() {
        return armorLoadoutService.getAllArmorLoadouts();
    }

    @GetMapping("/api/armorloadouts/{id}")
    public ArmorLoadout getArmorLoadoutById(@PathVariable String id) {
        return armorLoadoutService.getArmorLoadoutById(id);
    }

    // UPDATE
    @PutMapping("/api/armorloadouts/{id}")
    public ArmorLoadout updateArmorLoadout(@PathVariable String id, @Valid @RequestBody ArmorLoadoutFormDTO form) {
        return armorLoadoutService.updateArmorLoadout(id, form);
    }

    // DELETE
    @DeleteMapping("/api/armorloadouts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArmorLoadout(@PathVariable String id) {
        armorLoadoutService.deleteArmorLoadout(id);
    }
}
