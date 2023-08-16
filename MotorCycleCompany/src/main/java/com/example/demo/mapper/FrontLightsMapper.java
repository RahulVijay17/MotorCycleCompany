package com.example.demo.mapper;

import com.example.demo.dto.FrontLightsDTO;
import com.example.demo.model.FrontLights;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FrontLightsMapper {
    FrontLightsMapper INSTANCE = Mappers.getMapper(FrontLightsMapper.class);

    FrontLightsDTO frontLightsToDTO(FrontLights frontLights);

    FrontLights dtoToFrontLights(FrontLightsDTO frontLightsDTO);
}
