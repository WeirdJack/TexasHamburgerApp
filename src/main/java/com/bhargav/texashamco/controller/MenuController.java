package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.MenuDTO;
import com.bhargav.texashamco.models.Menu;
import com.bhargav.texashamco.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<MenuDTO>> getAllLocations() {

        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping(value = "page/{page_number}/page_size/{page_size}")
    public ResponseEntity<Page<Menu>> getMenusByPage(@PathVariable("page_number") int pageNumber, @PathVariable("page_size") int pageSize) {

        return ResponseEntity.ok(menuService.getMenusByPage(pageNumber, pageSize));
    }

    @GetMapping(value = "status/{menu_type}")
    public ResponseEntity<Page<Menu>> getMenusByStatus(@PathVariable("menu_type") String type) {

        return ResponseEntity.ok(menuService.getMenusByType(type));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMenu(@RequestBody MenuDTO menuDTO){

        menuService.addMenu(menuDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMenu(@RequestBody MenuDTO menuDTO){

        menuService.updateMenu(menuDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMenu(@RequestBody MenuDTO menuDTO){

        menuService.deleteMenu(menuDTO);
        return ResponseEntity.ok().build();
    }
}
