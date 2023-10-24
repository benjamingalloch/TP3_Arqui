package application.repository;


import application.dtos.CarreraDTO;
import application.model.Carrera;

import application.dtos.ReporteDTO;
import application.model.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {

    @Query(value = "SELECT c.nombre AS nombre_carrera, years.anio AS anio, COALESCE(inscriptos.count, 0) AS inscriptos, COALESCE(egresados.count, 0) AS egresados "
            + "FROM Carrera c "
            + "CROSS JOIN ( "
            + "    SELECT DISTINCT anioDeInscripcion AS anio FROM EstudianteCarrera "
            + "    UNION "
            + "    SELECT DISTINCT anioDeGraduacion AS anio FROM EstudianteCarrera WHERE anioDeGraduacion IS NOT NULL "
            + ") years "
            + "LEFT JOIN ("
            + "    SELECT ec.carrera, ec.anioDeInscripcion AS anio, COUNT(DISTINCT e.dni) AS count FROM EstudianteCarrera ec "
            + "    JOIN Estudiante e ON ec.estudiante = e.idEstudiante "
            + "    GROUP BY ec.carrera, ec.anioDeInscripcion "
            + ") inscriptos ON c.id = inscriptos.carrera AND years.anio = inscriptos.anio "
            + "LEFT JOIN ( "
            + "    SELECT ec.carrera, ec.anioDeGraduacion AS anio, COUNT(DISTINCT e.dni) AS count FROM  EstudianteCarrera ec "
            + "    JOIN  Estudiante e ON ec.estudiante = e.idEstudiante "
            + "    WHERE ec.anioDeGraduacion IS NOT NULL "
            + "    GROUP BY ec.carrera, ec.anioDeGraduacion "
            + ") egresados ON c.id = egresados.carrera AND years.anio = egresados.anio "
            + "ORDER BY c.nombre ASC, years.anio ASC", nativeQuery = true)
    List<ReporteDTO> getReporte();

}
