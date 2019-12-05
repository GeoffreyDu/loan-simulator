package fr.formation.simulator.repositories;

import fr.formation.simulator.dtos.LoanSimulationDto;
import fr.formation.simulator.dtos.LoanSimulationViewDto;
import fr.formation.simulator.entities.LoanSimulation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanSimulationRepository extends JpaRepository<LoanSimulation, Long> {
    LoanSimulationViewDto getById(Long id);
    Page<LoanSimulationViewDto> getAllProjectedBy(Pageable pageable);
}
