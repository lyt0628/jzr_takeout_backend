package icu.lyt0628.jzr_takeout.api;


import icu.lyt0628.jzr_takeout.api.dto.ServerResponse;
import icu.lyt0628.jzr_takeout.repo.IOrderRepo;
import icu.lyt0628.jzr_takeout.service.domain.impl.Order;
import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
    @Autowired
    IOrderRepo orderRepo;

    @PostMapping
    public ServerResponse<Object> takeOrder(@RequestBody Order order) {
        order.setPrice(300.1);

        orderRepo.addOrder(order);
        return ServerResponse.success();
    }

    @GetMapping
    public ServerResponse<Iterable<Order>> findOrdersByStatus(@RequestParam OrderStatus status) {
        var orders = orderRepo.findOrderByStatus(status);
        var l = new ArrayList<Order>();
        orders.subscribe(l::add);
        return ServerResponse.success(l);
    }

}
