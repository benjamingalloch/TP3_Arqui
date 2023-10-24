package application.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReporteDTO {
    private String nombre;
    private int anio;
    private Long inscriptos, egresados;

    public ReporteDTO(String nombre, int anio, Long inscriptos, Long egresados) {
        this.nombre = nombre;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public ReporteDTO(ReporteDTO reporteDTO) {
        this.nombre = reporteDTO.getNombre();
        this.anio = reporteDTO.getAnio();
        this.inscriptos = reporteDTO.getInscriptos();
        this.egresados = reporteDTO.getEgresados();
    }
}
