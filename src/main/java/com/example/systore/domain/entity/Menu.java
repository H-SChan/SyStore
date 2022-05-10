package com.example.systore.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    private String category;

    @ManyToMany(mappedBy = "menus")
    private List<Demand> demands = new ArrayList<>();

    public void setDemands(Demand demand) {
        if (!this.demands.contains(demand)) {
            this.demands.add(demand);
        }

        if (!demand.getMenus().contains(this)) {
            demand.getMenus().add(this);
        }
    }
}
