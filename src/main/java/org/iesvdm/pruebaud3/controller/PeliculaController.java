package org.iesvdm.pruebaud3.controller;

import org.iesvdm.pruebaud3.model.Pelicula;
import org.iesvdm.pruebaud3.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PeliculaController {

    // Iyeccion service
    @Autowired
    private PeliculaService peliculaService;

    // Rutas
    @GetMapping("/peliculas") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Pelicula> listaPeliculas =  peliculaService.listAll();
        model.addAttribute("listaPeliculas", listaPeliculas);

        return "peliculas";
    }
}
