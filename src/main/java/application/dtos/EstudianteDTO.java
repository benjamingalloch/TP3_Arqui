package application.dtos;

import application.model.Estudiante;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EstudianteDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private long dni;
    private String ciudadResidencia;
    private long libreta;

    public EstudianteDTO(Estudiante estudiante) {
        this.id
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.dni = estudiante.getDni();
        this.ciudadResidencia = estudiante.getCiudadDeResidencia();
        this.libreta = estudiante.getId();
    }

    public EstudianteDTO(String nombre, String apellido, int edad, String ciudadResidencia, String genero, long dni, long libreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudadResidencia = ciudadResidencia;
        this.genero = genero;
        this.dni = dni;
        this.libreta = libreta;
    }

    public EstudianteDTO(EstudianteDTO estudianteDTO) {
        this.nombre = estudianteDTO.getNombre();
        this.apellido = estudianteDTO.getApellido();
        this.edad = estudianteDTO.getEdad();
        this.ciudadResidencia = estudianteDTO.getCiudadResidencia();
        this.genero = estudianteDTO.getGenero();
        this.dni = estudianteDTO.getDni();
        this.libreta = estudianteDTO.getLibreta();
    }
}