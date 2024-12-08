package icu.lyt0628.jzr_takeout.repo;


import icu.lyt0628.jzr_takeout.service.domain.impl.Order;
import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;
import reactor.core.publisher.Flux;


public interface IOrderRepo {
    void addOrder(Order order);

    Flux<Order> findOrderByStatus(OrderStatus status);
}
