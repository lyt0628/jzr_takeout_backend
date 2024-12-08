package icu.lyt0628.jzr_takeout.service.domain.impl;


import icu.lyt0628.jzr_takeout.service.domain.OrderStatus;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDetail {
    Long orderId;
    Long driverId;
    OrderStatus status;
    Date userPayTime;
    Date shopCatchTime;
    Date driverCatchTime;
    Date driverConfirmTime;
    Date userConfirmTime;

    Date createdAt;
    Date updatedAt;

}
