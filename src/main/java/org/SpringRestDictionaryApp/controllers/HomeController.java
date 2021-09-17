package org.SpringRestDictionaryApp.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
    public String greeting(){
        return "Hello from home controller!";
    }
}
