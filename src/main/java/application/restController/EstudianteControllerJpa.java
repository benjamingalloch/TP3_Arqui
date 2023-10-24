package application.restController;

import application.dtos.EstudianteDTO;
import application.model.Estudiante;
import application.repository.EstudianteRepository;
import application.services.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("estudiantes")
public class EstudianteControllerJpa {

    private final EstudianteService estudianteService;

    @GetMapping("")
    public Iterable<EstudianteDTO> getEstudiantes(){
        return estudianteService.findAll();
    }

    @PostMapping("")
    public ResponseEntity newEstudiante(@RequestBody EstudianteDTO e){
        return estudianteService.save(e);
    }

    @GetMapping("/{id}")
    Optional<Estudiante> one(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/byLU/{numero}")
    public Iterable<Estudiante> getEstudiantesByNumeroDeLibreta(@PathVariable long numero){
        return repository.findByNumeroDeLibreta(numero);
    }

    @GetMapping("/byDNI/{dni}")
    public Estudiante getEstudianteByDNI(@PathVariable long dni){
        return repository.findByDNI(dni);
    }

    @GetMapping("/byGenero/{genero}")
    public Iterable<Estudiante> getEstudianteByGenero(@PathVariable String genero){
        return repository.findByGenero(genero);
    }

    @GetMapping("/byCarreraAndCiudad/{carrera}-{ciudad}")
    public Iterable<Estudiante> getEstudiantesByCarreraAndCiudad(@PathVariable String carrera, @PathVariable String ciudad){
        return repository.findAllByCarreraAndCiudad(carrera, ciudad);
    }
}
