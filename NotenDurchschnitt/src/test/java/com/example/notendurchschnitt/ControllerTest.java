package com.example.notendurchschnitt;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.notendurchschnitt.controller.Durchschnittcontroller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {
    @Autowired
    private Durchschnittcontroller durchschnittController;

    @Test
    void testController(){
        durchschnittController.fuegeNoteZu(2.0);
        durchschnittController.fuegeNoteZu(1.0);
        durchschnittController.fuegeNoteZu(3.0);
        assertThat(durchschnittController.drawDurchschnitt()).isEqualTo(2);
    }


}