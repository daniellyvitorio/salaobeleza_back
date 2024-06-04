package br.com.senai.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@RestController
public class ImageController {

    @GetMapping("/image")
    public Resource getImage() {
        return new ClassPathResource("static/mulher-pintando-unha.jpg");
    }
}