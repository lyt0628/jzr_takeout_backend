package icu.lyt0628.jzr_takeout.api;


import icu.lyt0628.jzr_takeout.api.dto.ServerResponse;
import icu.lyt0628.jzr_takeout.common.RecordConstants;
import icu.lyt0628.jzr_takeout.repo.IShopRepo;
import icu.lyt0628.jzr_takeout.service.domain.impl.Dish;
import icu.lyt0628.jzr_takeout.service.domain.impl.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/shops")
@Slf4j
public class ShopController {
    @Autowired
    IShopRepo shopRepo;

    @GetMapping("/dishes")
    ServerResponse<Iterable<Dish>> getAllValidDishes(){
       var dishes = shopRepo.findDishesByStatus(RecordConstants.NORMAL_STATUS);
       var l = new ArrayList<Dish>();
       dishes.subscribe(l::add);
       return ServerResponse.success(l);
    }

    @PostMapping
    public ServerResponse<Object> addShop(@RequestBody Shop shop) {
        shopRepo.addShop(shop);
        return ServerResponse.success();
    }

    @PostMapping("{shopId}/dishes")
    public ServerResponse<Object> addDishes(@RequestBody Dish dish) {
        shopRepo.addDish(dish);
        return ServerResponse.success();
    }

    @PostMapping("{shopId}/dishes/{dishName}/modify_price")
    public ServerResponse<Object> modifyDishPrice(
            @PathVariable Long shopId, @PathVariable String dishName ,
            @RequestBody Double price) {
        var dish = Dish.builder()
                .shopId(shopId)
                .dishName(dishName)
                .price(price)
                .build();
        shopRepo.updateDish(dish);
        return ServerResponse.success();
    }


    @DeleteMapping("{shopId}/dishes/{dishName}")
    public ServerResponse<Object> removeDish(
            @PathVariable Long shopId, @PathVariable String dishName) {
        var dish = Dish.builder()
                .shopId(shopId)
                .dishName(dishName)
                .status(1)
                .build();
        shopRepo.updateDish(dish);
        return ServerResponse.success();
    }
}
