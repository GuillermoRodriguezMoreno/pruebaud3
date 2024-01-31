package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.model.Idioma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class IdiomaDAOImpl implements IdiomaDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(Idioma idioma) {

    }

    @Override
    public List<Idioma> getAll() {
        return null;
    }

    @Override
    public Optional<Idioma> find(int id) {

        Idioma idioma =  jdbcTemplate
                .queryForObject("SELECT * FROM idioma WHERE id_idioma = ?;"
                        , (rs, rowNum) -> new Idioma(rs.getInt("id_idioma"),
                                rs.getString("nombre"),
                                rs.getDate("ultima_actualizacion"))
                        , id
                );

        if (idioma != null) {
            return Optional.of(idioma);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void update(Idioma idioma) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Idioma newIdioma(ResultSet rs) throws SQLException {
        return null;
    }
}
