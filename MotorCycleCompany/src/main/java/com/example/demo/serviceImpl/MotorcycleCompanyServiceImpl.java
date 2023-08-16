package com.example.demo.serviceImpl;

import com.example.demo.dto.MotorcycleCompanyDTO;
import com.example.demo.dto.ProductionLineDTO;
import com.example.demo.mapper.MotorcycleCompanyMapper;
import com.example.demo.model.AssemblyLine;
import com.example.demo.model.MotorcycleCompany;
import com.example.demo.model.ProductionLine;
import com.example.demo.repository.AssemblyLineRepository;
import com.example.demo.repository.MotorcycleCompanyRepository;
import com.example.demo.repository.ProductionLineRepository;
import com.example.demo.service.MotorcycleCompanyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MotorcycleCompanyServiceImpl implements MotorcycleCompanyService {

    @Autowired
    private MotorcycleCompanyRepository motorcycleCompanyRepository;
    @Autowired
    private ProductionLineRepository productionLineRepository;
    @Autowired
    private AssemblyLineRepository assemblyLineRepository;

    @Override
    public List<MotorcycleCompanyDTO> getAllCompany() {
        List<MotorcycleCompany> motorcycleCompanies = motorcycleCompanyRepository.findAll();
        return motorcycleCompanies.stream()
                .map(MotorcycleCompanyMapper.INSTANCE::motorcycleCompanyToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MotorcycleCompanyDTO saveMotorcycleCompany(MotorcycleCompanyDTO motorcycleCompanyDTO) {
        MotorcycleCompany motorcycleCompany = MotorcycleCompanyMapper.INSTANCE.dtoToMotorcycleCompany(motorcycleCompanyDTO);

        // Set MotorcycleCompany as the owner of the relationship with ProductionLines
        for (ProductionLine productionLine : motorcycleCompany.getProductionLines()) {
            productionLine.setMotorcycleCompany(motorcycleCompany);
        }

        // Set MotorcycleCompany as the owner of the relationship with AssemblyLine
        if (motorcycleCompany.getAssemblyLine() != null) {
            motorcycleCompany.getAssemblyLine().setMotorcycleCompany(motorcycleCompany);
        }

        MotorcycleCompany savedCompany = motorcycleCompanyRepository.save(motorcycleCompany);

        return MotorcycleCompanyMapper.INSTANCE.motorcycleCompanyToDTO(savedCompany);
    }


    @Override
    public MotorcycleCompanyDTO getMotorcycleCompanyById(Long id) {
        Optional<MotorcycleCompany> optionalCompany = motorcycleCompanyRepository.findById(id);
        return optionalCompany.map(MotorcycleCompanyMapper.INSTANCE::motorcycleCompanyToDTO).orElse(null);
    }

    @Override
    public void deleteMotorcycleCompany(Long id) {
        motorcycleCompanyRepository.deleteById(id);
    }

}