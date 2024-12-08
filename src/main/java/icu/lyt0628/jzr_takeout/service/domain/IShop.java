package icu.lyt0628.jzr_takeout.service.domain;

public interface IShop {
    void addDish(IDish dish);
    void removeDish(String dishName);
    void modifyPrice(Double newPrice);
}