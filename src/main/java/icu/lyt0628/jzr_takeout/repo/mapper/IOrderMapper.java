package icu.lyt0628.jzr_takeout.repo.mapper;

import icu.lyt0628.jzr_takeout.service.domain.impl.Order;
import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IOrderMapper {
    void addOrder(Order order);
    List<Order> findOrdersByStatus(OrderStatus status);
}
