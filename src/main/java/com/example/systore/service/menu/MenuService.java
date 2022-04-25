package com.example.systore.service.menu;

import com.example.systore.domain.dto.request.menu.MenuDto;
import com.example.systore.domain.dto.request.menu.SaveMenuDto;
import com.example.systore.domain.entity.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MenuService {
    @Transactional
    Menu saveMenu(SaveMenuDto saveMenuDto);

    @Transactional(readOnly = true)
    MenuDto findOne(Long id);

    @Transactional(readOnly = true)
    List<MenuDto> findMenus();

    @Transactional
    void deleteMenu(Long id);
}
