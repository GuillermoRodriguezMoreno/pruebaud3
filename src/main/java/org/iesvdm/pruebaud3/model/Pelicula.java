package org.iesvdm.pruebaud3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    // Atributos
    private int id;
    private String titulo;
    private String descripcion;
    private Date fecha_lanzamiento;
    private Idioma idioma;
    private int duracion_alquiler;
    private BigDecimal rental_rate;
    private int duracion;
    private BigDecimal replacement_cost;
    private Date ultima_actualizacion;
}
