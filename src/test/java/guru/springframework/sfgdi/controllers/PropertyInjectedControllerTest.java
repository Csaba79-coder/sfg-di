package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    // right click generate setup method!
    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
    }

    @Test
    void getGreeting() {
        // works without sout as well!
        System.out.println(controller.getGreeting());
    }
}