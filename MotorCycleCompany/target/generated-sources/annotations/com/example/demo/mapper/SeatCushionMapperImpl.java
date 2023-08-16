package com.example.demo.mapper;

import com.example.demo.dto.SeatCushionDTO;
import com.example.demo.model.SeatCushion;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T11:54:59+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class SeatCushionMapperImpl implements SeatCushionMapper {

    @Override
    public SeatCushionDTO seatCushionToDTO(SeatCushion seatCushion) {
        if ( seatCushion == null ) {
            return null;
        }

        SeatCushionDTO seatCushionDTO = new SeatCushionDTO();

        seatCushionDTO.setId( seatCushion.getId() );
        seatCushionDTO.setQuantity( seatCushion.getQuantity() );

        return seatCushionDTO;
    }

    @Override
    public SeatCushion dtoToSeatCushion(SeatCushionDTO seatCushionDTO) {
        if ( seatCushionDTO == null ) {
            return null;
        }

        SeatCushion seatCushion = new SeatCushion();

        seatCushion.setId( seatCushionDTO.getId() );
        seatCushion.setQuantity( seatCushionDTO.getQuantity() );

        return seatCushion;
    }
}
