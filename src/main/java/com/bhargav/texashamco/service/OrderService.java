package com.bhargav.texashamco.service;

import com.bhargav.texashamco.dto.OrderDTO;
import com.bhargav.texashamco.mapper.OrderMapper;
import com.bhargav.texashamco.models.Order;
import com.bhargav.texashamco.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public void placeOrder(OrderDTO orderDTO) {

        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.insert(order);
    }
}