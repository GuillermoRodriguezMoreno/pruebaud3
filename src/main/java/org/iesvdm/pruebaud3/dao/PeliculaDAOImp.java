package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.model.Categoria;
import org.iesvdm.pruebaud3.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.sql.PreparedStatement;
import org.springframework.jdbc.support.KeyHolder;



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

        String sqlInsert = """
							INSERT INTO pelicula (titulo, descripcion, fecha_lanzamiento, id_idioma, duracion_alquiler, rental_rate, duracion, replacement_cost, ultima_actualizacion) 
							VALUES  (     ?,         ?,         ?,       ?,         ?, ?, ?, ?, ?)
						   """;



        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado por lambda
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
            int idx = 1;
            ps.setString(idx++, pelicula.getTitulo());
            ps.setString(idx++, pelicula.getDescripcion());
            ps.setDate(idx++, new java.sql.Date(pelicula.getFecha_lanzamiento().getTime()));
            ps.setInt(idx++, pelicula.getIdioma().getId_idioma());
            ps.setInt(idx++, pelicula.getDuracion_alquiler());
            ps.setBigDecimal(idx++, pelicula.getRental_rate());
            ps.setInt(idx++, pelicula.getDuracion());
            ps.setBigDecimal(idx++, pelicula.getReplacement_cost());
            ps.setDate(idx, new java.sql.Date(pelicula.getUltima_actualizacion().getTime()));
            return ps;
        },keyHolder);

        pelicula.setId(keyHolder.getKey().intValue());

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

    public List<Categoria> getAllpeliCat() {

        String sqlString = """
                SELECT * FROM pelicula_categoria;
                """;

        List<Categoria> catList = this.jdbcTemplate.query(sqlString,
                (rs, rowNum) -> new Categoria(rs.getInt("id_pelicula"),
                        rs.getInt("id_categoria"),
                        rs.getDate("ultima_actualizacion")
                        )
        );

        return catList;
    }
}
