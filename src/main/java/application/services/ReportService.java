package application.services;

import application.dtos.EstudianteDTO;
import application.dtos.ReporteDTO;
import application.repository.EstudianteCarreraRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("reporteService")
@RequiredArgsConstructor
public class ReportService {

    @Autowired
    private EstudianteCarreraRepository repository;

    @Transactional
    public List<ReporteDTO> getReporte() {
        return repository.getReporte().stream().map(ReporteDTO::new).toList();
    }
}
