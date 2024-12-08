package icu.lyt0628.jzr_takeout.service.domain.impl;


import icu.lyt0628.jzr_takeout.service.domain.IDish;
import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Dish implements IDish {
    Long shopId;
    String dishName;
    Double price;
    Date createdAt;
    Date updatedAt;
    Integer status;
}
