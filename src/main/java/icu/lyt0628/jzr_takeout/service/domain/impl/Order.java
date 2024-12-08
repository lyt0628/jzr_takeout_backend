package icu.lyt0628.jzr_takeout.service.domain.impl;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    Long id;
    Long consumerId;
    Long shopId;
    String dishName;
    Double price;
    OrderDetail detail;
}