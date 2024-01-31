package org.iesvdm.pruebaud3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    private int id_pelicula;
    private int id_categoria;
    private Date ultima_actializacion;
}
