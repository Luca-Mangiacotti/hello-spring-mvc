package org.lessons.java.springintro.hello_spring_mvc.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("/saluti")
    public String Saluti(Model model, @RequestParam(name = "name") String name) {
        final String formattedName = name.substring(0, 1).toUpperCase()
                + name.substring(1, name.length()).toLowerCase();
        model.addAttribute("name", formattedName);
        model.addAttribute("time", LocalTime.now());
        model.addAttribute("email", name + "@gmail.com");
        return "saluti";
    }

}
