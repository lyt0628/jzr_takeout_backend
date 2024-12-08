package icu.lyt0628.jzr_takeout.service.domain;



public enum OrderStatus {
    WaitingConsumerPay,
    ConsumerCanceled,
    ConsumerPaid,
    ShopCaught,
    WaitingDriverCaught,
    DriverCaught,
    DriverConfirmed,
    ConsumerConfirmed
}
