package application.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "estudiantecarrera")
public class EstudianteCarrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "anioDeInscripcion")
    private int anioDeInscripcion;
    @Column
    private int anioDeGraduacion;
    @Column
    private int antiguedad;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "carrera_ID")
    private Carrera carrera;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "estudiante_ID")
    private Estudiante estudiante;

    public EstudianteCarrera() {
        super();
    }

    public EstudianteCarrera(int anioDeInscripcion, int anioDeGraduacion, int antiguedad, Estudiante estudiante, Carrera carrera) {
        this.anioDeInscripcion = anioDeInscripcion;
        this.anioDeGraduacion = anioDeGraduacion;
        this.antiguedad = antiguedad;
        this.estudiante = estudiante;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        String carreraNombre = null;
        if (carrera != null) {
            carreraNombre = carrera.getNombre();
        }
        String estudianteNombre = null;
        if (estudiante != null) {
            estudianteNombre = estudiante.getNombre() + " " + estudiante.getApellido();
        }
        return "EstudianteCarrera{" +
                "id=" + id +
                ", anioDeInscripcion=" + anioDeInscripcion +
                ", anioDeGraduacion=" + anioDeGraduacion +
                ", antiguedad=" + antiguedad +
                ", carrera=" + carreraNombre +
                ", estudiante=" + estudianteNombre +
                "}/n";
    }
}
