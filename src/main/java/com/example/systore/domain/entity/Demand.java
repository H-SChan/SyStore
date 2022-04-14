package com.example.systore.domain.entity;

import com.example.systore.enums.DemandStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @CreatedDate
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    private Menu menu;

    @ManyToOne
    private Seat seat;

    public void setSeat(Seat seat) {
        if (this.seat != null) {
            this.seat.getDemands().remove(this);
        }
        this.seat = seat;
        seat.getDemands().add(this);
    }

    public void setMenu(Menu menu) {
        if (this.menu != null) {
            this.menu.getOrders().remove(this);
        }
        this.menu = menu;
        menu.getOrders().add(this);
    }
}
