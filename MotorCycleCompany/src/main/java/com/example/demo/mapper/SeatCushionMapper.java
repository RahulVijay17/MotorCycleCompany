package com.example.demo.mapper;

import com.example.demo.dto.SeatCushionDTO;
import com.example.demo.model.SeatCushion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatCushionMapper {
    SeatCushionMapper INSTANCE = Mappers.getMapper(SeatCushionMapper.class);

    SeatCushionDTO seatCushionToDTO(SeatCushion seatCushion);

    SeatCushion dtoToSeatCushion(SeatCushionDTO seatCushionDTO);
}
