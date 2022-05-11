package com.example.systore.domain.entity;

import com.example.systore.enums.DemandStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Demand {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demand_id")
    private Long id;

    @CreatedDate
    @Column
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private DemandStatus status;

    @ManyToMany
    private List<Menu> menus = new ArrayList<>();

    @OneToOne
    private Seat seat;

    public void addSeat(Seat seat) {
        if (this.seat != null) {
            this.seat.setDemand(null);
        }
        this.seat = seat;
        seat.setDemand(this);
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void addMenu(Menu menu) {
        if (!this.menus.contains(menu)) {
            this.menus.add(menu);
        }

        if (!menu.getDemands().contains(this)) {
            menu.getDemands().add(this);
        }
    }
}
