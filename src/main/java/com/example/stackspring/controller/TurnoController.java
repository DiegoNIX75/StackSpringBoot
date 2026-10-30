package com.example.stackspring.controller;

import com.example.stackspring.model.Turno;
import com.example.stackspring.model.TurnoRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    Queue<Turno> turnos = new LinkedList<>();
    private int contador = 0;

    @PostMapping
    public Turno pedirTurno(@RequestBody TurnoRequest request) {
        contador++;
        Turno turno = new Turno(contador, request.getNombre());
        turnos.offer(turno);
        return turno;
    }

    @GetMapping("/siguiente")
    public String siguiente() {
        var a = turnos.poll();



        return "Se retira " + a.getNombre();
    }

    @GetMapping
    public Queue<Turno> verCola() {

        return turnos;
    }
}