package icu.lyt0628.jzr_takeout.repo.impl;


import icu.lyt0628.jzr_takeout.repo.IOrderRepo;
import icu.lyt0628.jzr_takeout.repo.mapper.IOrderDetailMapper;
import icu.lyt0628.jzr_takeout.repo.mapper.IOrderMapper;
import icu.lyt0628.jzr_takeout.service.domain.impl.Order;
import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;
import icu.lyt0628.jzr_takeout.service.factory.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class OrderRepo implements IOrderRepo {
    @Autowired
    IOrderMapper orderMapper;
    @Autowired
    IOrderDetailMapper detailMapper;
    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
        OrderFactory.newOrder(order);
        detailMapper.addOrderDetail(order.getDetail());
    }

    @Override
    public Flux<Order> findOrderByStatus(OrderStatus status) {
       var orders =  orderMapper.findOrdersByStatus(status);
        return Flux.fromIterable(orders);
    }
}
