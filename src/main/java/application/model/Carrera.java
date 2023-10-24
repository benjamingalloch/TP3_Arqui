package application.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
@Entity
@Data
@Table(name = "carrera")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private String nombre;
    @Column
    private int duracion;

    @JsonManagedReference
    @OneToMany(mappedBy = "carrera", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<EstudianteCarrera> estudianteCarrera;

    public Carrera() {
        super();
    }

    public Carrera(String nombre, int duracion) {
        super();
        this.nombre = nombre;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "\nCarrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                "}";
    }
}
