package com.example.mhlmbackend.dto;

import com.example.mhlmbackend.model.ArmorPiece;

public record ArmorLoadoutFormDTO (
        String name,
        ArmorPiece headArmorPiece,
        ArmorPiece chestArmorPiece,
        ArmorPiece glovesArmorPiece,
        ArmorPiece waistArmorPiece,
        ArmorPiece legsArmorPiece
) {}
