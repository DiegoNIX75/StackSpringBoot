package com.example.stackspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/pila")
public class PilaController {
    Stack<Character> chars = new Stack<>();

    @PostMapping
    public Character agregar(@RequestParam Character valor) {

        return chars.push(valor);
    }

    @GetMapping("/pop")
    public Character sacar() {

        return chars.pop();
    }

    @GetMapping
    public Stack<Character> verPila() {

        return chars;
    }
}
