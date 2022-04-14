package com.example.systore.service.menu;

import com.example.systore.domain.dto.request.menu.SaveMenuDto;
import com.example.systore.domain.entity.Menu;
import com.example.systore.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public Menu saveMenu(SaveMenuDto saveMenuDto) {
        if (saveMenuDto.isSetMenu()) {
            saveMenuDto.setCategory("세트 메뉴");
        }
        Menu menu = Menu.builder()
                .name(saveMenuDto.getName())
                .category(saveMenuDto.getCategory())
                .price(saveMenuDto.getPrice())
                .build();

        return menuRepository.save(menu);
    }
}
