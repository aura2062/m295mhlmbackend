package com.example.mhlmbackend;

import java.util.ArrayList;

public class ArmorLoadout {
    private String id;
    private String name;
    private ArrayList<ArmorPiece> armorpieces;

    public ArmorLoadout(String id, String name, ArrayList<ArmorPiece> armorpieces) {
        this.id = id;
        this.name = name;
        if  (armorpieces.size() != 5) {
            throw new IllegalArgumentException("ArmorLoadout must have 5 ArmorPieces, one of each type");
        }
        this.armorpieces = armorpieces;
    }

    public String getId() { return id; };
    public void setId(String id) {this.id = id;};
    public String getName() { return name; };
    public void setName(String name) { this.name = name; };
    public ArrayList<ArmorPiece> getArmorPieces() { return armorpieces; };
    public void setArmorPieces(ArrayList<ArmorPiece> armorpieces) { this.armorpieces = armorpieces; };
}