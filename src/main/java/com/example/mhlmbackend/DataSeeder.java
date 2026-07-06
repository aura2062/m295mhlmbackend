package com.example.mhlmbackend;

import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.repository.ArmorLoadoutRepository;
import com.example.mhlmbackend.repository.ArmorPieceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ArmorPieceRepository armorPieceRepository;
    private final ArmorLoadoutRepository armorLoadoutRepository;

    public DataSeeder (ArmorPieceRepository armorPieceRepository, ArmorLoadoutRepository armorLoadoutRepository) {
        this.armorPieceRepository = armorPieceRepository;
        this.armorLoadoutRepository = armorLoadoutRepository;
    }

    private List<ArmorPiece> getStartArmorPieces() {
        return List.of(
                new ArmorPiece("1", "Leather Headgear", "head"),
                new ArmorPiece("2", "Leather Mail", "chest"),
                new ArmorPiece("3", "Leather Gloves", "gloves"),
                new ArmorPiece("4", "Leather Belt", "waist"),
                new ArmorPiece("5", "Leather Trousers", "legs")
        );
    }

    private List<ArmorLoadout> getStartArmorLoadouts() {
        List<ArmorPiece> getStartArmorPieces = getStartArmorPieces();
        ArmorPiece head = getStartArmorPieces.get(0);
        ArmorPiece chest = getStartArmorPieces.get(1);
        ArmorPiece gloves = getStartArmorPieces.get(2);
        ArmorPiece waist = getStartArmorPieces.get(3);
        ArmorPiece legs = getStartArmorPieces.get(4);

        return List.of(
                new ArmorLoadout(
                        "leather set",
                        head,
                        chest,
                        gloves,
                        waist,
                        legs
                ),
                new ArmorLoadout(
                        "leather set v2",
                        head,
                        chest,
                        gloves,
                        waist,
                        legs
                )
        );
    }

    @Override
    public void run(String... args) {
        if (armorPieceRepository.count() == 0) {
            armorPieceRepository.saveAll(getStartArmorPieces());
            System.out.println("DataSeeder: " + armorPieceRepository.count() + " armor pieces have been written to the Database");
        } else {
            System.out.println("DataSeeder: DB already contains armor piece data, seeding not necessary");
        }
        if (armorLoadoutRepository.count() == 0) {
            armorLoadoutRepository.saveAll(getStartArmorLoadouts());
            System.out.println("DataSeeder: " + armorLoadoutRepository.count() + " loadouts have been written to the Database");
        } else {
            System.out.println("DataSeeder: DB already contains loadout data, seeding not necessary");
        }
    }
}
