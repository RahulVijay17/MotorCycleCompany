package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL)
    private List<FrontLights> frontLights;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL)
    private List<SeatCushion> seatCushions;

}
