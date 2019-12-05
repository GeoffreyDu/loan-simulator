package fr.formation.simulator.services;

import fr.formation.simulator.dtos.LoanSimulationDto;
import fr.formation.simulator.dtos.LoanSimulationViewDto;
import fr.formation.simulator.entities.LoanSimulation;
import fr.formation.simulator.repositories.LoanSimulationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoanSimulationServiceImpl implements LoanSimulationService {

    private final LoanSimulationRepository loanRepo;

    protected LoanSimulationServiceImpl(LoanSimulationRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    @Override
    public void create(LoanSimulationDto dto) {
        LoanSimulation simulation = new LoanSimulation();
        populateAndSave(dto, simulation);
    }

    @Override
    public LoanSimulationViewDto getOne(Long id) {
        return loanRepo.getById(id);
    }

    @Override
    public Page<LoanSimulationViewDto> getAll(Pageable pageable){
        return loanRepo.getAllProjectedBy(pageable);
    }

    @Override
    public void update(Long id, LoanSimulationDto dto) {
        LoanSimulation simulation = loanRepo.findById(id).get();
        populateAndSave(dto, simulation);
    }

    @Override
    public void delete(Long id) {
        loanRepo.deleteById(id);
    }

    private void populateAndSave(LoanSimulationDto dto, LoanSimulation simulation){
        simulation.setAmount(dto.getAmount());
        simulation.setLoanRate(dto.getLoanRate());
        simulation.setLoanType(dto.getLoanType());
        simulation.setInsuranceRate(dto.getInsuranceRate());
        simulation.setDuration(dto.getDuration());
        simulation.setStartDate(dto.getStartDate());

        loanRepo.save(simulation);
    }
}
