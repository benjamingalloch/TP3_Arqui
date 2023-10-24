package application.restController;

import application.dtos.CarreraDTO;
import application.model.Carrera;
import application.model.EstudianteCarrera;
import application.services.CarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("carreras")
public class CarreraControllerJpa {

    private final CarreraService carreraService;

    @GetMapping("")
    public Iterable<CarreraDTO> getCarreras(){
        return carreraService.findAll();
    }

    @PostMapping("")
    public ResponseEntity newCarrera(@RequestBody CarreraDTO c) throws Exception{
        return carreraService.save(c);
    }

    @GetMapping("/{id}")
    public CarreraDTO one(@PathVariable long id){
        return carreraService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public CarreraDTO getCarrerasByNombre(@PathVariable String nombre) {
        return carreraService.findByNombre(nombre);
    }

    @PutMapping("/matricular")
    public EstudianteCarrera matricular(@RequestBody EstudianteCarrera ec) {
        return null;
    }

}
