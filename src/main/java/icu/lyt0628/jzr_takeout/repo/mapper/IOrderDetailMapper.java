package icu.lyt0628.jzr_takeout.repo.mapper;


import icu.lyt0628.jzr_takeout.service.domain.impl.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderDetailMapper {
   void addOrderDetail(OrderDetail detail);
}
