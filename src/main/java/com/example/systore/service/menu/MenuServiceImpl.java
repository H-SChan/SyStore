package com.example.systore.service.menu;

import com.example.systore.domain.dto.request.menu.MenuDto;
import com.example.systore.domain.dto.request.menu.SaveMenuDto;
import com.example.systore.domain.entity.Menu;
import com.example.systore.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private static ModelMapper modelMapper = new ModelMapper();

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

    @Override
    @Transactional(readOnly = true)
    public MenuDto findOne(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 메뉴입니다.")
        );
        return modelMapper.map(menu, MenuDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuDto> findMenus() {
        return menuRepository.findAll().stream().map(
                m -> modelMapper.map(m, MenuDto.class)
        ).toList();
    }

    @Override
    @Transactional
    public void deleteMenu(Long id) {
        menuRepository.delete(menuRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 메뉴입니다.")
        ));
    }
}
