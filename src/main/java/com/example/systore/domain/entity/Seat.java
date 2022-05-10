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

    @ManyToMany(mappedBy = "seats")
    private List<Demand> demands = new ArrayList<>();

    public void setDemands(Demand demand) {
        if (!this.demands.contains(demand)) {
            this.demands.add(demand);
        }

        if (!demand.getSeats().contains(this)) {
            demand.getSeats().add(this);
        }
    }
}
