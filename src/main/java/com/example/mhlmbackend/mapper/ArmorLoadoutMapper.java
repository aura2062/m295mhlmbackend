package com.example.mhlmbackend.mapper;

import com.example.mhlmbackend.dto.ArmorLoadoutFormDTO;
import com.example.mhlmbackend.model.ArmorLoadout;

public class ArmorLoadoutMapper {

    public static ArmorLoadout toEntity(ArmorLoadoutFormDTO dto) {
        ArmorLoadout armorLoadout = new ArmorLoadout();
        armorLoadout.setName(dto.name());
        armorLoadout.setHeadArmorPiece(dto.headArmorPiece());
        armorLoadout.setChestArmorPiece(dto.chestArmorPiece());
        armorLoadout.setGlovesArmorPiece(dto.glovesArmorPiece());
        armorLoadout.setWaistArmorPiece(dto.waistArmorPiece());
        armorLoadout.setLegsArmorPiece(dto.legsArmorPiece());
        return armorLoadout;
    }
}
