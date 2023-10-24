package application.repository;

import application.dtos.EstudianteDTO;
import application.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT es " +
            "FROM Estudiante es WHERE es.numeroDeLibreta = :numero")
    public List<EstudianteDTO> findByNumeroDeLibreta(@Param("numero")long numero);

    @Query("SELECT es " +
            "FROM Estudiante es WHERE es.dni = :dni")
    public EstudianteDTO findByDNI(@Param("dni") long dni);

    @Query("SELECT es " +
            "FROM Estudiante es WHERE es.genero LIKE :genero")
    public List<EstudianteDTO> findByGenero(@Param("genero") String genero);

    @Query("SELECT es " +
            "FROM Estudiante es  " +
            "JOIN es.estudianteCarrera ec " +
            "WHERE ec.carrera.nombre  = :carrera " +
            "AND es.ciudadDeResidencia LIKE :ciudad ")
    public List<EstudianteDTO> findAllByCarreraAndCiudad(@Param("carrera") String carrera, @Param("ciudad") String ciudad);

}
