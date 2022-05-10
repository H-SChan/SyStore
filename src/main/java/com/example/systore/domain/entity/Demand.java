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

    @ManyToMany
    private List<Seat> seats = new ArrayList<>();

    public void setSeat(Seat seat) {
        if (!this.seats.contains((seat))) {
            this.seats.add(seat);
        }

        if (!seat.getDemands().contains(this)) {
            seat.getDemands().add(this);
        }
    }

    public void setMenu(Menu menu) {
        if (!this.menus.contains(menu)) {
            this.menus.add(menu);
        }

        if (!menu.getDemands().contains(this)) {
            menu.getDemands().add(this);
        }
    }
}
