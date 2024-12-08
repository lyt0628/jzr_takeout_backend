package icu.lyt0628.jzr_takeout.service.domain.impl;


import lombok.*;

import java.util.Date;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Shop {
    Long id;
    Long sellerId;
    String shopName;
    Date createdAt;
    Date updatedAt;
    Integer status;
}
