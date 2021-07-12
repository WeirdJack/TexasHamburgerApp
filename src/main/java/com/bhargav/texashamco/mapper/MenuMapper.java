package com.bhargav.texashamco.mapper;

import com.bhargav.texashamco.dto.LocationDTO;
import com.bhargav.texashamco.dto.MenuDTO;
import com.bhargav.texashamco.models.Location;
import com.bhargav.texashamco.models.Menu;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    MenuDTO toMenuDTO(Menu menu);
    Menu toMenu(MenuDTO menuDTO);
    List<MenuDTO> toMenuDTOs(List<Menu> menus);
    List<Menu> toMenus(List<MenuDTO> menuDTOs);

    //Page<MenuDTO> toMenuDTOsPage(Page<Menu> menus);
}
