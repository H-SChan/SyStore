package com.example.systore.controller;

import com.example.systore.domain.dto.request.menu.MenuDto;
import com.example.systore.domain.dto.request.menu.SaveMenuDto;
import com.example.systore.domain.dto.response.Response;
import com.example.systore.domain.dto.response.ResponseEntity;
import com.example.systore.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menus")
    public Response saveMenu(SaveMenuDto saveMenuDto) {
        menuService.saveMenu(saveMenuDto);

        return new Response(HttpStatus.OK, "성공");
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDto>> getMenus() {
        List<MenuDto> menus = menuService.findMenus();

        return new ResponseEntity<>(HttpStatus.OK, "성공", menus);
    }

    @GetMapping("/menus/{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable Long id) {
        MenuDto menu = menuService.findOne(id);

        return new ResponseEntity<>(HttpStatus.OK, "성공", menu);
    }

    @DeleteMapping("/menus/{id}")
    public Response deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);

        return new Response(HttpStatus.OK, "성공");
    }
}
