package dev.rayh.supservice.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/general")
public class GeneralController {

    @GetMapping("")
    public ResponseEntity hello(){
        return new ResponseEntity<>(new Greeting("hello"), HttpStatus.OK);
    }
}

record Greeting(String message) {
}
