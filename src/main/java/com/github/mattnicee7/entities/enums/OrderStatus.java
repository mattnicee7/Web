package com.github.mattnicee7.entities.enums;

import lombok.Getter;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    @Getter private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public static OrderStatus getOrderStatusByCode(int code) {

        for (OrderStatus orderStatus : values()) {
            if (orderStatus.getCode() == code)
                return orderStatus;
        }

        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
