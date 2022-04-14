package com.example.systore.domain.entity;

import com.example.systore.enums.SeatStatus;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Seat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @OneToMany(mappedBy = "table")
    private List<Order> orders = new ArrayList<>();

}
