package com.example.mhlmbackend.controller;

import com.example.mhlmbackend.exception.ArmorLoadoutNotFoundException;
import com.example.mhlmbackend.model.ArmorLoadout;
import com.example.mhlmbackend.model.ArmorPiece;
import com.example.mhlmbackend.service.ArmorLoadoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@WebMvcTest(ArmorLoadoutController.class)
public class ArmorLoadoutControllerTest {

    @Autowired
    private MockMvcTester mvc;

    @MockitoBean
    private ArmorLoadoutService service;

    @Test
    void getByIdReturns200WithBody() {
        ArmorLoadout armorLoadout = new ArmorLoadout();
        armorLoadout.setId(1L);
        armorLoadout.setName("testarmorname");
        armorLoadout.setHeadArmorPiece(new ArmorPiece("1", "Leather Headgear", "head"));
        armorLoadout.setChestArmorPiece(new ArmorPiece("2", "Leather Mail", "chest"));
        armorLoadout.setGlovesArmorPiece(new ArmorPiece("3", "Leather Gloves", "gloves"));
        armorLoadout.setWaistArmorPiece(new ArmorPiece("4", "Leather Belt", "waist"));
        armorLoadout.setLegsArmorPiece(new ArmorPiece("5", "Leather Trousers", "legs"));

        given(service.getArmorLoadoutById(String.valueOf(1L))).willReturn(armorLoadout);

        assertThat(mvc.get().uri("/api/armorloadouts/1"))
                .hasStatusOk()
                .bodyJson()
                .extractingPath("$.name")
                .isEqualTo("testarmorname");
    }

    @Test
    void getByIdReturns404WhenServiceThrows() {
        given(service.getArmorLoadoutById(String.valueOf(999L)))
                .willThrow(new ArmorLoadoutNotFoundException("999"));

        assertThat(mvc.get().uri("/api/armorloadouts/999"))
                .hasStatus(HttpStatus.NOT_FOUND);
    }
}