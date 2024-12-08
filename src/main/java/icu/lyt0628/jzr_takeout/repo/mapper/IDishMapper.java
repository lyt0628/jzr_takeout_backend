package icu.lyt0628.jzr_takeout.repo.mapper;

import icu.lyt0628.jzr_takeout.service.domain.impl.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDishMapper {
    void addDish(Dish dish);
    void updateDish(Dish dish);
    List<Dish> findDishesByStatus(Integer status);
}
