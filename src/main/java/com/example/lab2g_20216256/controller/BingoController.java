package com.example.lab2g_20216256.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class BingoController {


    ArrayList<ArrayList> TARJETAS = new ArrayList<>();
    int CANTIDAD;
    int LONGITUD;
    @GetMapping("/registro")
    public String registrarDatos(){
        return "formulario";
    }

    @PostMapping("/comienzo")
    public String comenzarJuego(@RequestParam("longitud") int longitud,
                                @RequestParam("cantTarje") int cantidad, Model model){

        List<String> numeros = new ArrayList<>();


        Random r = new Random();
        //Se genera los numeros random

        ArrayList<ArrayList> cartas = new ArrayList<>();
        for (int m=0; m<cantidad; m++ ){
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
        this.TARJETAS=cartas;
        this.CANTIDAD=cantidad;
        this.LONGITUD=longitud;
        System.out.println(cartas);
        return "tarjetas";
    }


    //En esta parte es en donde se van a validar
    @PostMapping("/InicioJuego")
    public String empezar(@RequestParam("Numero") String numero,
                          Model model){

        //Necesitamos encontrar las coordenadas que coincidan con el número que requerimos,
        //Oh por así decirlo los indices, los llamaremos x,y y z, para cada arreglo del más
        //grande al más pequeño
        int x;
        int y;
        int z;

        //Ahora procedemos a buscar para enviar un arreglo con las pocisiones que contengan el número
        ArrayList<ArrayList> coordenadas = new ArrayList<>();
        for (int m=0; m<CANTIDAD; m++ ){
            for(int i=0; i < LONGITUD; i++ ){
                for(int j=0; j < LONGITUD; j++ ){
                    System.out.println();
                    if(((ArrayList) TARJETAS.get(m).get(i)).get(j)==numero){
                        ArrayList<Integer> coordenada = new ArrayList<>();
                        coordenada.add(m);
                        coordenada.add(i);
                        //coordenadas.add(j);
                    }
                }

            }

        }
        //Luego mandamos la lista de coordenadas y ponemos un if con th en la vista html para volver verde sucesivamente :(

        return "tarjetas";
    }



}
