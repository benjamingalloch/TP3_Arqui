package application.repository;

import application.dtos.CarreraDTO;
import application.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT c FROM Carrera c WHERE c.nombre LIKE :nombre")
    CarreraDTO findByNombre(@Param("nombre") String nombre);
    @Query("SELECT COUNT(ec) FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "WHERE c.nombre = :carrera AND ec.anioDeInscripcion = :anio")
    Long findCantInscriptos(@Param("carrera") String carrera, @Param("anio") int anio);
    @Query("SELECT COUNT(ec) FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "WHERE c.nombre = :carrera AND ec.anioDeGraduacion = :anio")
    Long findCantEgresados(@Param("carrera") String carrera,@Param("anio") int anio);
    @Query("SELECT DISTINCT ec.anioDeInscripcion " +
            "FROM EstudianteCarrera ec " +
            "WHERE ec.carrera.id = :id " +
            "AND ec.anioDeInscripcion > 0 " +
            "UNION " +
            "SELECT DISTINCT ec.anioDeGraduacion " +
            "FROM EstudianteCarrera ec " +
            "WHERE ec.carrera.id = :id " +
            "AND ec.anioDeGraduacion > 0 " +
            "ORDER BY 1 ASC")
    List<Integer> findAniosActivos(@Param("id") int id);
    @Query("SELECT c FROM Carrera c " +
            "JOIN c.estudianteCarrera ec " +
            "GROUP BY c " +
            "HAVING COUNT(ec) > 0 " +
            "ORDER BY COUNT(ec) DESC ")
    List<CarreraDTO> findAllConInscriptos();

}
