package com.example.demo.service;

import com.example.demo.dto.MotorcycleCompanyDTO;
import com.example.demo.model.MotorcycleCompany;

import java.util.List;

public interface MotorcycleCompanyService {

     List<MotorcycleCompanyDTO> getAllCompany();

     MotorcycleCompanyDTO saveMotorcycleCompany(MotorcycleCompanyDTO motorcycleCompanyDTO);

     MotorcycleCompanyDTO getMotorcycleCompanyById(Long id);

     void deleteMotorcycleCompany(Long id);

}
