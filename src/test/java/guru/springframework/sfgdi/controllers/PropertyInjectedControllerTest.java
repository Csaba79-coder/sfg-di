package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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