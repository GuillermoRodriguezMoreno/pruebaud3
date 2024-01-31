package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.model.Idioma;
import org.iesvdm.pruebaud3.model.Pelicula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IdiomaDAO {
    public void create(Idioma idioma);

    public List<Idioma> getAll();
    public Optional<Idioma> find(int id);

    public void update(Idioma idioma);

    public void delete(int id);

    public Idioma newIdioma(ResultSet rs) throws SQLException;
}
