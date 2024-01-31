package org.iesvdm.pruebaud3.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesvdm.pruebaud3.model.Idioma;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {

    @NotNull
    private int id;
    @NotNull
    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 3, message = "Minimo 3 caracteres")
    private String titulo;
    @Size(max=300, message = "no puede tener mas de 300 caracteres")
    private String descripcion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_lanzamiento;
    private Idioma idioma;
    @NotNull
    private int duracion_alquiler;
    @NotNull
    @DecimalMin(value="0.0", message = "Debe ser mayor o igual a 0.0")
    private BigDecimal rental_rate;
    @Min(value = 0, message = "debe ser mayor que 0")
    private int duracion;
    @NotNull
    @DecimalMin(value="19.99", message = "Debe ser mayor o igual a 19.99")
    private BigDecimal replacement_cost;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ultima_actualizacion;

    @NotNull
    private int id_idioma;
}
