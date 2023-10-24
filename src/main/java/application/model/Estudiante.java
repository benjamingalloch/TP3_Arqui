package application.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "estudiante")
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column
    private long dni;
    @Column
    private String ciudadDeResidencia;
    @Column
    private long numeroDeLibreta;

    @JsonManagedReference
    @OneToMany(mappedBy = "estudiante", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<EstudianteCarrera> estudianteCarrera;

    public Estudiante() {
        super();
    }

    public Estudiante(long dni, String nombre, String apellido, int edad, String genero, String ciudadDeResidencia, long numeroDeLibreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudadDeResidencia = ciudadDeResidencia;
        this.numeroDeLibreta = numeroDeLibreta;
    }

    @Override
    public String toString() {
        return "\nEstudiante{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido=" + apellido +
                "}";
    }
}
