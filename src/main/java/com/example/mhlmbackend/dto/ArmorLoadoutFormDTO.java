package com.example.mhlmbackend.dto;

import com.example.mhlmbackend.model.ArmorPiece;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArmorLoadoutFormDTO (
        @NotBlank(message = "is not allowed to be empty")
        String name,

        @NotNull(message = "is not allowed to be empty")
        ArmorPiece headArmorPiece,

        @NotNull(message = "is not allowed to be empty")
        ArmorPiece chestArmorPiece,

        @NotNull(message = "is not allowed to be empty")
        ArmorPiece glovesArmorPiece,

        @NotNull(message = "is not allowed to be empty")
        ArmorPiece waistArmorPiece,

        @NotNull(message = "is not allowed to be empty")
        ArmorPiece legsArmorPiece
) {}
