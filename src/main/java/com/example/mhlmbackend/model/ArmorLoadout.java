package com.example.mhlmbackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "ArmorLoadouts")
public class ArmorLoadout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "head_slot_id")
    private ArmorPiece headArmorPiece;
    @ManyToOne
    @JoinColumn(name = "chest_slot_id")
    private ArmorPiece chestArmorPiece;
    @ManyToOne
    @JoinColumn(name = "gloves_slot_id")
    private ArmorPiece glovesArmorPiece;
    @ManyToOne
    @JoinColumn(name = "waist_slot_id")
    private ArmorPiece waistArmorPiece;
    @ManyToOne
    @JoinColumn(name = "legs_slot_id")
    private ArmorPiece legsArmorPiece;

    public ArmorLoadout() {}

    public ArmorLoadout(String name, ArmorPiece headArmorPiece, ArmorPiece chestArmorPiece, ArmorPiece glovesArmorPiece, ArmorPiece waistArmorPiece, ArmorPiece legsArmorPiece) {
        this.name = name;
        this.headArmorPiece = headArmorPiece;
        this.chestArmorPiece = chestArmorPiece;
        this.glovesArmorPiece = glovesArmorPiece;
        this.waistArmorPiece = waistArmorPiece;
        this.legsArmorPiece = legsArmorPiece;
    }

    public Long getId() { return id; };
    public void setId(Long id) { this.id = id; };
    public String getName() { return name; };
    public void setName(String name) { this.name = name; };
    public ArmorPiece getHeadArmorPiece() { return headArmorPiece; };
    public void setHeadArmorPiece(ArmorPiece headArmorPiece) { this.headArmorPiece = headArmorPiece; };
    public ArmorPiece getChestArmorPiece() { return chestArmorPiece; };
    public void setChestArmorPiece(ArmorPiece chestArmorPiece) { this.chestArmorPiece = chestArmorPiece; };
    public ArmorPiece getGlovesArmorPiece() { return glovesArmorPiece; };
    public void setGlovesArmorPiece(ArmorPiece glovesArmorPiece) { this.glovesArmorPiece = glovesArmorPiece; };
    public ArmorPiece getWaistArmorPiece() { return waistArmorPiece; };
    public void setWaistArmorPiece(ArmorPiece waistArmorPiece) { this.waistArmorPiece = waistArmorPiece; };
    public ArmorPiece getLegsArmorPiece() { return legsArmorPiece; };
    public void setLegsArmorPiece(ArmorPiece legsArmorPiece) { this.legsArmorPiece = legsArmorPiece; };
}