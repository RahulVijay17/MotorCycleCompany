package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotorcycleDTO {
    private Long id;
    private String type;
    private List<FrontLightsDTO> frontLights;
    private List<SeatCushionDTO> seatCushions;

}
