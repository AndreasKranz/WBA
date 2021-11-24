package com.example.notendurchschnitt2;

import com.example.notendurchschnitt2.average.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerTest {

    @Autowired
    NotenController notenController;

    @Test
    void testController(){
        //notenController.addNote(1.0);
        //notenController.addNote(1.0);
        //notenController.addNote(4.0);
        assertThat(notenController.drawDurchschnitt()).isEqualTo(2.0);
    }
}
