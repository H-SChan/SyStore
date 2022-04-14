package com.example.systore.service.menu;

import com.example.systore.domain.entity.Menu;
import com.example.systore.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public Menu saveMenu() {
        return null;
    }
}
