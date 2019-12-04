package fr.formation.simulator.repositories;

import fr.formation.simulator.entities.LoanSimulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanSimulationRepository extends JpaRepository<LoanSimulation, Long> {
}
