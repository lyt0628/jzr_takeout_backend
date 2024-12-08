package icu.lyt0628.jzr_takeout.repo;


import icu.lyt0628.jzr_takeout.service.domain.impl.Dish;
import icu.lyt0628.jzr_takeout.service.domain.impl.Shop;
import reactor.core.publisher.Flux;

public interface IShopRepo {
    void addShop(Shop shop);

    void addDish(Dish dish);

    void updateDish(Dish dish);

    Flux<Dish> findDishesByStatus(Integer status);
}
