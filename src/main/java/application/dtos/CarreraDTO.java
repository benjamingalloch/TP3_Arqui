package application.dtos;

import application.model.Carrera;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class CarreraDTO {
    private int id;
    private String nombre;
    private int duracion;

    public CarreraDTO(Carrera carrera) {
        this.id = carrera.getId();
        this.nombre = carrera.getNombre();
        this.duracion = carrera.getDuracion();
    }

    public CarreraDTO(int id, String nombre, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public CarreraDTO(CarreraDTO carreraDTO) {
        this.id = carreraDTO.getId();
        this.nombre = carreraDTO.getNombre();
        this.duracion = carreraDTO.duracion;
    }

}
