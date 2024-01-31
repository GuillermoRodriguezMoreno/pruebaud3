package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.model.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PeliculaDAO {

    public void create(Pelicula pelicula);

    public List<Pelicula> getAll();
    public Optional<Pelicula> find(int id);

    public void update(Pelicula pelicula);

    public void delete(int id);

    public Pelicula newPelicula(ResultSet rs) throws SQLException;
}
