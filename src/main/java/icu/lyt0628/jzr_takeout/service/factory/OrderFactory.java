package icu.lyt0628.jzr_takeout.service.factory;

import icu.lyt0628.jzr_takeout.service.domain.impl.Order;
import icu.lyt0628.jzr_takeout.service.domain.impl.OrderDetail;
import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;

import java.util.Date;

public class OrderFactory {
    public static Order newOrder(
            Long orderId, Long consumerId, Long shopId, String dishName, Double price){
        var order = new Order();
        order.setId(orderId);
        order.setConsumerId(consumerId);
        order.setShopId(shopId);
        order.setDishName(dishName);
        order.setPrice(price);

        var detail = new OrderDetail();
        order.setDetail(detail);
        detail.setOrderId(orderId);

        detail.setStatus(OrderStatus.WaitingConsumerPay);
        detail.setCreatedAt(new Date());
        return order;
    }


    public static Order newOrder(Order order){

        var detail = new OrderDetail();
        order.setDetail(detail);
        detail.setOrderId(order.getId());

        detail.setStatus(OrderStatus.WaitingConsumerPay);
        detail.setCreatedAt(new Date());
        return order;
    }
}
