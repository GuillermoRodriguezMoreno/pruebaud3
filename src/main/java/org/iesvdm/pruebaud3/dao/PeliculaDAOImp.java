package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaDAOImp implements PeliculaDAO{

    // inyeccion JDBC
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // Añado DAO para añadir Idioma
    @Autowired
    private IdiomaDAOImpl idiomaDAO;

    @Override
    public void create(Pelicula pelicula) {

    }

    @Override
    public List<Pelicula> getAll() {

        String sqlString = """
                SELECT * FROM pelicula;
                """;

        List<Pelicula> peliculasList = this.jdbcTemplate.query(sqlString,
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getDate("fecha_lanzamiento"),
                        idiomaDAO.find(rs.getInt("id_idioma")).get(),
                        rs.getInt("duracion_alquiler"),
                        rs.getBigDecimal("rental_rate"),
                        rs.getInt("duracion"),
                        rs.getBigDecimal("replacement_cost"),
                        rs.getDate("ultima_actualizacion"))
        );

        return peliculasList;
    }

    @Override
    public Optional<Pelicula> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Pelicula newPelicula(ResultSet rs) throws SQLException {
        return null;
    }
}
