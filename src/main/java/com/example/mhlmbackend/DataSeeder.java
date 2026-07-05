package com.example.mhlmbackend;

import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.repository.ArmorPieceRepository;
import com.example.mhlmbackend.service.ArmorPieceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ArmorPieceRepository armorPieceRepository;

    public DataSeeder (ArmorPieceRepository armorPieceRepository) {
        this.armorPieceRepository = armorPieceRepository;
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

    @Override
    public void run(String... args) {
        if (armorPieceRepository.count() == 0) {
            armorPieceRepository.saveAll(getStartArmorPieces());
            System.out.println("DataSeeder: " + armorPieceRepository.count() + " armor pieces have written to the Database");
        } else {
            System.out.println("DataSeeder: DB already contains armor piece data, seeding not necessary");
        }
    }
}
