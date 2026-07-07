package com.example.mhlmbackend.dto;

import com.example.mhlmbackend.model.ArmorPiece;
import jakarta.validation.constraints.NotBlank;

public record ArmorLoadoutFormDTO (
        @NotBlank(message = "is not allowed to be empty")
        String name,

        @NotBlank(message = "is not allowed to be empty")
        ArmorPiece headArmorPiece,

        @NotBlank(message = "is not allowed to be empty")
        ArmorPiece chestArmorPiece,

        @NotBlank(message = "is not allowed to be empty")
        ArmorPiece glovesArmorPiece,

        @NotBlank(message = "is not allowed to be empty")
        ArmorPiece waistArmorPiece,

        @NotBlank(message = "is not allowed to be empty")
        ArmorPiece legsArmorPiece
) {}
