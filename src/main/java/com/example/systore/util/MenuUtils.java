package com.example.systore.util;

import com.example.systore.domain.entity.Menu;
import com.example.systore.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MenuUtils {

    private final MenuRepository menuRepository;

    public List<Menu> getMenusListByIds(List<Long> menuIds) {
        return menuRepository.findAllById(menuIds);
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }
}
