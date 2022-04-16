package com.example.systore.controller;

import com.example.systore.domain.dto.request.menu.SaveMenuDto;
import com.example.systore.domain.dto.response.Response;
import com.example.systore.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public Response saveMenu(SaveMenuDto saveMenuDto) {
        menuService.saveMenu(saveMenuDto);

        return new Response(HttpStatus.OK, "성공");
    }
}
