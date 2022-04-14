package com.example.systore.service.menu;

import com.example.systore.domain.dto.request.menu.SaveMenuDto;
import com.example.systore.domain.entity.Menu;
import org.springframework.transaction.annotation.Transactional;

public interface MenuService {
    @Transactional
    Menu saveMenu(SaveMenuDto saveMenuDto);
}
