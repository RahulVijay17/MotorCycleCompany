package com.example.demo.controller;

import com.example.demo.dto.AssemblyLineDTO;
import com.example.demo.dto.MotorcycleCompanyDTO;
import com.example.demo.model.AssemblyLine;
import com.example.demo.model.MotorcycleCompany;
import com.example.demo.model.ProductionLine;
import com.example.demo.repository.AssemblyLineRepository;
import com.example.demo.repository.MotorcycleCompanyRepository;
import com.example.demo.repository.ProductionLineRepository;
import com.example.demo.service.MotorcycleCompanyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MotorcycleCompanyController {

    @Autowired
    private MotorcycleCompanyService motorcycleCompanyService;
    @Autowired
    private MotorcycleCompanyRepository motorcycleCompanyRepository;
    @Autowired
    private ProductionLineRepository productionLineRepository;
    @Autowired
    private AssemblyLineRepository assemblyLineRepository;

    @GetMapping
  //  @CircuitBreaker(name = "getAllCompany",fallbackMethod = "serviceDown")
    public ResponseEntity<List<MotorcycleCompanyDTO>> getAllCompanies()  {
       return new ResponseEntity<>(motorcycleCompanyService.getAllCompany(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MotorcycleCompanyDTO> createCompany(@RequestBody MotorcycleCompanyDTO motorcycleCompanyDTO) {
        return new ResponseEntity<>(motorcycleCompanyService.saveMotorcycleCompany(motorcycleCompanyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotorcycleCompanyDTO> getCompanyById(@PathVariable Long id) {
        MotorcycleCompanyDTO companyDTO = motorcycleCompanyService.getMotorcycleCompanyById(id);
        if (companyDTO != null) {
            return ResponseEntity.ok(companyDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Long id) {
        motorcycleCompanyService.deleteMotorcycleCompany(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<String> serviceDown(Throwable throwable) {
        return new ResponseEntity<>("Sorry, our systems are busy! Please try again later.",HttpStatus.SERVICE_UNAVAILABLE);
    }

    @GetMapping("/motorcycleCompany/removeProductionLine")
    public ResponseEntity<MotorcycleCompanyDTO> removeProductionLineFromCompany(@RequestParam Long motorcycleCompanyId,
                                                                                @RequestParam Long productionLineId,
                                                                                @RequestParam Long assemblyLineId) {
        Optional<MotorcycleCompany> optionalCompany = motorcycleCompanyRepository.findById(motorcycleCompanyId);
        Optional<ProductionLine> optionalProductionLine = productionLineRepository.findById(productionLineId);
        Optional<AssemblyLine> optionalAssemblyLine = assemblyLineRepository.findById(assemblyLineId);

        if (optionalCompany.isPresent() && optionalProductionLine.isPresent()) {
            MotorcycleCompany motorcycleCompany = optionalCompany.get();
            ProductionLine productionLine = optionalProductionLine.get();

            AssemblyLineDTO assemblyLineDTO = new AssemblyLineDTO();
            assemblyLineDTO.setId(optionalAssemblyLine.get().getId());
            assemblyLineDTO.setType(optionalAssemblyLine.get().getType());
            assemblyLineDTO.setProductionRate(optionalAssemblyLine.get().getProductionRate());

            // Check if the production line belongs to the motorcycle company
            if (motorcycleCompany.getProductionLines().contains(productionLine)) {

                // Remove the production line from the motorcycle company
                motorcycleCompany.getProductionLines().remove(productionLine);
                // Set the foreign key to null at the entity level
                productionLine.setMotorcycleCompany(null);
                // Save the updated MotorcycleCompany entity
                motorcycleCompanyRepository.save(motorcycleCompany);

                // Create a DTO with the desired response fields
                MotorcycleCompanyDTO responseDTO = new MotorcycleCompanyDTO();
                responseDTO.setId(motorcycleCompany.getId());
                responseDTO.setName(motorcycleCompany.getName());
                responseDTO.setNumberOfMotorcycles(motorcycleCompany.getNumberOfMotorcycles());
                responseDTO.setAssemblyLine(assemblyLineDTO);

                return ResponseEntity.ok(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}