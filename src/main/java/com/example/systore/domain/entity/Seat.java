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

    @OneToOne(mappedBy = "seat")
    private Demand  demand;

    public void addDemand(Demand demand) {
        if (this.demand != null) {
            this.demand.setSeat(null);
        }
        this.demand = demand;
        demand.setSeat(this);
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }
}
