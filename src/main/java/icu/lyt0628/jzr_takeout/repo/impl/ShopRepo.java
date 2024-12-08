package icu.lyt0628.jzr_takeout.repo.impl;


import icu.lyt0628.jzr_takeout.repo.IShopRepo;
import icu.lyt0628.jzr_takeout.repo.mapper.IDishMapper;
import icu.lyt0628.jzr_takeout.repo.mapper.IShopMapper;
import icu.lyt0628.jzr_takeout.service.domain.impl.Dish;
import icu.lyt0628.jzr_takeout.service.domain.impl.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ShopRepo implements IShopRepo {
    @Autowired
    IShopMapper shopMapper;
    @Autowired
    IDishMapper dishMapper;

    @Override
    public void addShop(Shop shop) {
        shopMapper.addShop(shop);
    }

    @Override
    public void addDish(Dish dish) {
        dishMapper.addDish(dish);
    }

    @Override
    public void updateDish(Dish dish) {
        dishMapper.updateDish(dish);
    }

    @Override
    public Flux<Dish> findDishesByStatus(Integer status) {
        return Flux.fromIterable(dishMapper
                .findDishesByStatus(status));
    }


}
