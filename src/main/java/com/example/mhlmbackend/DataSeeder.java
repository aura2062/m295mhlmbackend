package com.example.mhlmbackend;

import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.repository.ArmorPieceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ArmorPieceRepository armorPieceRepository;
    private final ObjectMapper objectMapper;


    public DataSeeder (ArmorPieceRepository armorPieceRepository, ObjectMapper objectMapper) {
        this.armorPieceRepository = armorPieceRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception{
        if (armorPieceRepository.count() == 0) {
            ClassPathResource resource = new ClassPathResource("armorpieces.json");

            try (InputStream inputStream = resource.getInputStream()) {
                List<ArmorPiece> armorPieces = objectMapper.readValue(inputStream, new TypeReference<List<ArmorPiece>>(){});
                armorPieceRepository.saveAll(armorPieces);
                System.out.println("DataSeeder: " + armorPieceRepository.count() + " armor pieces have been written to the Database");
            }
        } else {
            System.out.println("DataSeeder: DB already contains armor piece data, seeding not necessary");
        }
    }
}
