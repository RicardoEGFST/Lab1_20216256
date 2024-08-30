package com.example.lab2g_20216256.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class BingoController {


    int intentos;

    @GetMapping("/registro")
    public String registrarDatos(){
        return "formulario";
    }

    @PostMapping("/comienzo")
    public String comenzarJuego(@RequestParam("longitud") int longitud,
                                @RequestParam("cantTarje") int intentos, Model model){

        List<String> numeros = new ArrayList<>();


        Random r = new Random();
        //Se genera los numeros random

        ArrayList<ArrayList> cartas = new ArrayList<>();
        for (int m=0; m<intentos; m++ ){
            ArrayList<ArrayList> arreglos = new ArrayList<>();
            for(int i=0; i < longitud; i++ ){
                ArrayList<String> arreglo = new ArrayList<>();
                for(int j=0; j < longitud; j++ ){
                    int n=r.nextInt(longitud*longitud);
                    arreglo.add(Integer.toString(n));
                }
                arreglos.add(arreglo);
            }
            cartas.add(arreglos);
        }

        model.addAttribute("tarjetas", cartas);


        System.out.println(cartas);
        return "tarjetas";
    }



}
