package org.iesvdm.pruebaud3.controller;

import org.iesvdm.pruebaud3.DTO.PeliculaDTO;
import org.iesvdm.pruebaud3.dao.IdiomaDAO;
import org.iesvdm.pruebaud3.model.Pelicula;
import org.iesvdm.pruebaud3.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PeliculaController {

    // Iyeccion service
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private IdiomaDAO idiomaDAO;

    // Rutas
    @GetMapping("/peliculas") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Pelicula> listaPeliculas =  peliculaService.listAll();
        model.addAttribute("listaPeliculas", listaPeliculas);

        return "peliculas";
    }

    @GetMapping("/peliculas/crear")
    public String crear(Model model){

        PeliculaDTO peliculaDTO = new PeliculaDTO();
        model.addAttribute("peliculaDto", peliculaDTO);

        return "crear-pelicula";
    }

    @PostMapping("/peliculas/crear")
    public String submitCrear(@ModelAttribute("pelicula") PeliculaDTO peliculaDTO) {

        Pelicula pelicula = new Pelicula(peliculaDTO.getId(),
                peliculaDTO.getTitulo(),
                peliculaDTO.getDescripcion(),
                peliculaDTO.getFecha_lanzamiento(),
                idiomaDAO.find(peliculaDTO.getId_idioma()).get(),
                peliculaDTO.getDuracion_alquiler(),
                peliculaDTO.getRental_rate(),
                peliculaDTO.getDuracion(),
                peliculaDTO.getReplacement_cost(),
                peliculaDTO.getUltima_actualizacion());

        peliculaService.newPelicula(pelicula);

        return "redirect:/peliculas" ;

    }
}
