package icu.lyt0628.jzr_takeout.repo.mapper;

import icu.lyt0628.jzr_takeout.service.domain.impl.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IShopMapper {
    void addShop(Shop shop);
    void updateShop(Shop shop);
    List<Shop> getAllShops();
    List<Shop> findShopsByNameLike(String likeName);
    List<Shop> findShopsBySellerId(Long sellerId);
}
