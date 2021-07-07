package com.bhargav.texashamco.service;

import com.bhargav.texashamco.dto.MenuDTO;
import com.bhargav.texashamco.mapper.MenuMapper;
import com.bhargav.texashamco.models.Location;
import com.bhargav.texashamco.models.Menu;
import com.bhargav.texashamco.repository.LocationRepository;
import com.bhargav.texashamco.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    MenuMapper menuMapper;

    public List<MenuDTO> getAllMenus(){

        return menuMapper.toMenuDTOs(menuRepository.findAll());
    }

    public Page<Menu> getMenusByPage(int pageNumber, int pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return menuRepository.findAll(pageable);
    }

    public Page<Menu> getMenusByType(String menuType){

        Pageable pageable = PageRequest.of(0, 10);

        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("type").is(menuType));

        List<Menu> filteredMenus =
                mongoTemplate.find(query, Menu.class, "menu");
        Page<Menu> menuPage = PageableExecutionUtils.getPage(
                filteredMenus,
                pageable,
                () -> mongoTemplate.count(query, Menu.class));

        return menuPage;
    }

    public void addMenu(MenuDTO menuDTO) {

        menuRepository.insert(menuMapper.toMenu(menuDTO));
    }

    public void updateMenu(MenuDTO menuDTO) {

        Menu menu = menuMapper.toMenu(menuDTO);
        Menu existing = menuRepository.findById(menu.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Location with ID: " + menu.getId())
                ));

        existing.setId(menu.getId());
        //existing.setName(menu.getName());
        menuRepository.save(existing);
    }

    public void deleteMenu(MenuDTO menuDTO) {

        Menu menu = menuMapper.toMenu(menuDTO);
        Menu existing = menuRepository.findById(menu.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Menu with ID: " + menu.getId())
                ));

        menuRepository.delete(existing);
    }
}
