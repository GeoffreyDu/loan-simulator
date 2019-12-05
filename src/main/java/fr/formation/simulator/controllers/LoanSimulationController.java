package fr.formation.simulator.controllers;

import fr.formation.simulator.dtos.LoanSimulationDto;
import fr.formation.simulator.dtos.LoanSimulationViewDto;
import fr.formation.simulator.services.LoanSimulationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/simulation")
public class LoanSimulationController {

    private final LoanSimulationService loanService;

    protected LoanSimulationController(LoanSimulationService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/{id}")
    protected LoanSimulationViewDto getOne(@PathVariable("id") Long id){
        return loanService.getOne(id);
    }

    @GetMapping
    protected Page<LoanSimulationViewDto> getAll(@RequestParam("p") int page, @RequestParam("s") int size ){
        Pageable pageable = PageRequest.of(page, size);
        return loanService.getAll(pageable);
    }

    @PostMapping
    protected void create(@Valid @RequestBody LoanSimulationDto dto){
        loanService.create(dto);
    }

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id, @Valid @RequestBody LoanSimulationDto dto){
        loanService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id){
        loanService.delete(id);
    }
}
