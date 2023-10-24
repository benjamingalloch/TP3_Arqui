package application.services;

import application.dtos.CarreraDTO;
import application.dtos.EstudianteDTO;
import application.model.Carrera;
import application.model.Estudiante;
import application.repository.CarreraRepository;
import application.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("estudianteService")
@RequiredArgsConstructor
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional
    public EstudianteDTO findByDNI(long dni) {
        try {
            EstudianteDTO estudiante = this.estudianteRepository.findByDNI(dni);
            if (estudiante != null) {
                return new EstudianteDTO(estudiante.getNombre(), estudiante.getApellido(), estudiante.getEdad(), estudiante.getCiudadResidencia(), estudiante.getGenero(), estudiante.getDni(), estudiante.getLibreta());
            } else {
                //Hacer algo en caso de no encontrar
                return null;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @Transactional
    public List<EstudianteDTO> findByGenero(String genero) {
        return estudianteRepository.findByGenero(genero).stream().map(EstudianteDTO::new).toList();
    }
    @Transactional
    public List<EstudianteDTO> findByNumeroDeLibreta(long nro) {
        return estudianteRepository.findByNumeroDeLibreta(nro).stream().map(EstudianteDTO::new).toList();
    }
    @Transactional
    public List<EstudianteDTO> findAllByCarreraAndCiudad(String carrera, String ciudad) {
        return estudianteRepository.findAllByCarreraAndCiudad(carrera, ciudad).stream().map(EstudianteDTO::new).toList();
    }

    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll().stream().map(EstudianteDTO::new).toList();
    }

    public ResponseEntity save(EstudianteDTO e) {
        if(!this.estudianteRepository.existsById((long) e.getId())){
            this.carreraRepository.save(new Carrera(c.getNombre(), c.getDuracion()));
            return new ResponseEntity(c.getId(), HttpStatus.CREATED);
        }
        return null;
    }
}
