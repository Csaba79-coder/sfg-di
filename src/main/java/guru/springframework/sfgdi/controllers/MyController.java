package guru.springframework.sfgdi.controllers;


import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello() {
        System.out.println("Hello World!\nThank you for all John Thompson!");
        return "\nHi Folks";
    }
}
