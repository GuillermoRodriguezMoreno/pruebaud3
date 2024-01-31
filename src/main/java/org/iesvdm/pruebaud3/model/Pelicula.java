package org.iesvdm.pruebaud3.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 3, message = "Minimo 3 caracteres")
    private String titulo;
    @Size(max=300, message = "no puede tener mas de 300 caracteres")
    private String descripcion;
    private Date fecha_lanzamiento;
    private Idioma idioma;
    private int duracion_alquiler;
    @DecimalMin(value="0.0", message = "Debe ser mayor o igual a 0.0")
    private BigDecimal rental_rate;
    @Min(value = 0, message = "debe ser mayor que 0")
    private int duracion;
    @DecimalMin(value="19.99", message = "Debe ser mayor o igual a 19.99")
    private BigDecimal replacement_cost;
    private Date ultima_actualizacion;
}
