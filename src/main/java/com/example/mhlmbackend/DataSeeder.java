package com.example.mhlmbackend;

import com.example.mhlmbackend.repository.ArmorPieceRepository;
import com.example.mhlmbackend.service.ArmorPieceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ArmorPieceService armorPieceService;
    private final ArmorPieceRepository armorPieceRepository;
    // later: ArmorLoadoutService <- maybe?
    // later: ArmorLoadoutRepository <- maybe?

    public DataSeeder (ArmorPieceService armorPieceService, ArmorPieceRepository armorPieceRepository) {
        this.armorPieceService = armorPieceService;
        this.armorPieceRepository = armorPieceRepository;
    }

    @Override
    public void run(String... args) {
        if (armorPieceRepository.count() == 0) {
            armorPieceRepository.saveAll(armorPieceService.getAllArmorPieces());
            System.out.println("DataSeeder: " + armorPieceRepository.count() + " armor pieces have written to the Database");
        } else {
            System.out.println("DataSeeder: DB already contains armor piece data, seeding not necessary");
        }
    }
}
