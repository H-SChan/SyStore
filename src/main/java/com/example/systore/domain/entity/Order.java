package com.example.systore.domain.entity;

import com.example.systore.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
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
    private Table table;

    public void setTable(Table table) {
        if (this.table != null) {
            this.table.getOrders().remove(this);
        }
        this.table = table;
        table.getOrders().add(this);
    }

    public void setMenu(Menu menu) {
        if (this.menu != null) {
            this.menu.getOrders().remove(this);
        }
        this.menu = menu;
        menu.getOrders().add(this);
    }
}
