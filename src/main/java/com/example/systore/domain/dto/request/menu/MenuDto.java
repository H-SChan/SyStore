package com.example.systore.domain.dto.request.menu;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuDto {

    private Long id;
    private String name;
    private Integer price;
    private String category;
}
