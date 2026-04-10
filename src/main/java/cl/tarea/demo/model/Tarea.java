package cl.tarea.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarea {
    private int id;
    private String descripcion;
    private String estadoDeLaTarea;
    private String prioridad;
    private int fechaAsociada;
}
