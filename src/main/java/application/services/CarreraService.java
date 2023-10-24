package application.services;

import application.dtos.CarreraDTO;
import application.dtos.EstudianteDTO;
import application.model.Carrera;
import application.repository.CarreraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("carreraService")
@RequiredArgsConstructor
public class CarreraService {
    private CarreraRepository carreraRepository;

    @Transactional
    public ResponseEntity save(CarreraDTO c) {
        if(!this.carreraRepository.existsById((long) c.getId())){
            this.carreraRepository.save(new Carrera(c.getNombre(), c.getDuracion()));
            return new ResponseEntity(c.getId(), HttpStatus.CREATED);
        }
        return null;
    }
    @Transactional
    public List<CarreraDTO> findAll() {
        return carreraRepository.findAll().stream().map(CarreraDTO::new).toList();
    }

    @Transactional
    public CarreraDTO findById(long id) {
        Optional<Carrera> c = carreraRepository.findById(id);
        if (c != null) {
            return new CarreraDTO(c.get());
        }
        //No se encontro la carrera
        return null;
    }

    @Transactional
    public CarreraDTO findByNombre(String nombre) {
        try {
            CarreraDTO c = this.carreraRepository.findByNombre(nombre);
            if (c != null) {
                return new CarreraDTO(c.getId(), c.getNombre(), c.getDuracion());
            } else {
                //Hacer algo en caso de no encontrar
                return null;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Transactional
    public List<CarreraDTO> findAllConInscriptos() {
        return carreraRepository.findAllConInscriptos().stream().map(CarreraDTO::new).toList();
    }


}
