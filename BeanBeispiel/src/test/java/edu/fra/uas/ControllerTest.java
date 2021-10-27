package edu.fra.uas;

import static org.assertj.core.api.Assertions.assertThat;

import edu.fra.uas.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import edu.fra.uas.controller.BeanController;

@SpringBootTest
public class ControllerTest {
    @Autowired
    private BeanController beanController;
    @Autowired
    private MessageService messageService;
    @Test
    void testController() {
        assertThat(beanController.putMessage("Das ist ein Test"))
                .isEqualTo(" put message: Das ist ein Test");
    }

    @Test
    void testIncrement() {
        assertThat(messageService.getCounter()).isEqualTo(4);
    }
}