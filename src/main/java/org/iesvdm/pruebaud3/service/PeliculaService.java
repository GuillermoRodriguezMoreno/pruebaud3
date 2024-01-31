package org.iesvdm.pruebaud3.service;

import org.iesvdm.pruebaud3.dao.PeliculaDAO;
import org.iesvdm.pruebaud3.dao.PeliculaDAOImp;
import org.iesvdm.pruebaud3.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    // Inyeccion DAO
    @Autowired
    private PeliculaDAO peliculaDAO;

    public List<Pelicula> listAll(){

        return peliculaDAO.getAll();
    }

    public void newPelicula(Pelicula pelicula){

        peliculaDAO.create(pelicula);
    }

    public long conteoPeliculas(){

        long total = this.peliculaDAO.getAll().size();

        return total;
    }

    public double costeHorror(){
        // Cat = 11;
        return 0.0;
    }

}
