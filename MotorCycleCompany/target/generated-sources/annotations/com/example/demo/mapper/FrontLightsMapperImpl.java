package com.example.demo.mapper;

import com.example.demo.dto.FrontLightsDTO;
import com.example.demo.model.FrontLights;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T12:31:07+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class FrontLightsMapperImpl implements FrontLightsMapper {

    @Override
    public FrontLightsDTO frontLightsToDTO(FrontLights frontLights) {
        if ( frontLights == null ) {
            return null;
        }

        FrontLightsDTO frontLightsDTO = new FrontLightsDTO();

        frontLightsDTO.setId( frontLights.getId() );
        frontLightsDTO.setQuantity( frontLights.getQuantity() );

        return frontLightsDTO;
    }

    @Override
    public FrontLights dtoToFrontLights(FrontLightsDTO frontLightsDTO) {
        if ( frontLightsDTO == null ) {
            return null;
        }

        FrontLights frontLights = new FrontLights();

        frontLights.setId( frontLightsDTO.getId() );
        frontLights.setQuantity( frontLightsDTO.getQuantity() );

        return frontLights;
    }
}
