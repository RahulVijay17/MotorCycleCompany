package com.example.demo.mapper;

import com.example.demo.dto.MotorcycleDTO;
import com.example.demo.model.Motorcycle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FrontLightsMapper.class, SeatCushionMapper.class})
public interface MotorcycleMapper {
    MotorcycleMapper INSTANCE = Mappers.getMapper(MotorcycleMapper.class);


    MotorcycleDTO motorcycleToDTO(Motorcycle motorcycle);


    Motorcycle dtoToMotorcycle(MotorcycleDTO motorcycleDTO);
}
