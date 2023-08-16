package com.example.demo.mapper;

import com.example.demo.dto.FrontLightsDTO;
import com.example.demo.dto.MotorcycleDTO;
import com.example.demo.dto.SeatCushionDTO;
import com.example.demo.model.FrontLights;
import com.example.demo.model.Motorcycle;
import com.example.demo.model.SeatCushion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T12:31:07+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class MotorcycleMapperImpl implements MotorcycleMapper {

    private final FrontLightsMapper frontLightsMapper = FrontLightsMapper.INSTANCE;
    private final SeatCushionMapper seatCushionMapper = SeatCushionMapper.INSTANCE;

    @Override
    public MotorcycleDTO motorcycleToDTO(Motorcycle motorcycle) {
        if ( motorcycle == null ) {
            return null;
        }

        MotorcycleDTO motorcycleDTO = new MotorcycleDTO();

        motorcycleDTO.setId( motorcycle.getId() );
        motorcycleDTO.setType( motorcycle.getType() );
        motorcycleDTO.setFrontLights( frontLightsListToFrontLightsDTOList( motorcycle.getFrontLights() ) );
        motorcycleDTO.setSeatCushions( seatCushionListToSeatCushionDTOList( motorcycle.getSeatCushions() ) );

        return motorcycleDTO;
    }

    @Override
    public Motorcycle dtoToMotorcycle(MotorcycleDTO motorcycleDTO) {
        if ( motorcycleDTO == null ) {
            return null;
        }

        Motorcycle motorcycle = new Motorcycle();

        motorcycle.setId( motorcycleDTO.getId() );
        motorcycle.setType( motorcycleDTO.getType() );
        motorcycle.setFrontLights( frontLightsDTOListToFrontLightsList( motorcycleDTO.getFrontLights() ) );
        motorcycle.setSeatCushions( seatCushionDTOListToSeatCushionList( motorcycleDTO.getSeatCushions() ) );

        return motorcycle;
    }

    protected List<FrontLightsDTO> frontLightsListToFrontLightsDTOList(List<FrontLights> list) {
        if ( list == null ) {
            return null;
        }

        List<FrontLightsDTO> list1 = new ArrayList<FrontLightsDTO>( list.size() );
        for ( FrontLights frontLights : list ) {
            list1.add( frontLightsMapper.frontLightsToDTO( frontLights ) );
        }

        return list1;
    }

    protected List<SeatCushionDTO> seatCushionListToSeatCushionDTOList(List<SeatCushion> list) {
        if ( list == null ) {
            return null;
        }

        List<SeatCushionDTO> list1 = new ArrayList<SeatCushionDTO>( list.size() );
        for ( SeatCushion seatCushion : list ) {
            list1.add( seatCushionMapper.seatCushionToDTO( seatCushion ) );
        }

        return list1;
    }

    protected List<FrontLights> frontLightsDTOListToFrontLightsList(List<FrontLightsDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<FrontLights> list1 = new ArrayList<FrontLights>( list.size() );
        for ( FrontLightsDTO frontLightsDTO : list ) {
            list1.add( frontLightsMapper.dtoToFrontLights( frontLightsDTO ) );
        }

        return list1;
    }

    protected List<SeatCushion> seatCushionDTOListToSeatCushionList(List<SeatCushionDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SeatCushion> list1 = new ArrayList<SeatCushion>( list.size() );
        for ( SeatCushionDTO seatCushionDTO : list ) {
            list1.add( seatCushionMapper.dtoToSeatCushion( seatCushionDTO ) );
        }

        return list1;
    }
}
