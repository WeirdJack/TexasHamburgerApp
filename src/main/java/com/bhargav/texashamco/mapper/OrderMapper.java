package com.bhargav.texashamco.mapper;

import com.bhargav.texashamco.dto.OrderDTO;
import com.bhargav.texashamco.dto.ReservationDTO;
import com.bhargav.texashamco.models.Order;
import com.bhargav.texashamco.models.Reservation;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);
}
