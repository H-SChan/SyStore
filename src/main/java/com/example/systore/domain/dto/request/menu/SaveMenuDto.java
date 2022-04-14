package com.example.systore.domain.dto.request.menu;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveMenuDto {

    private String name;
    private int price;
    private String category;
    private boolean isSetMenu = false;
}
