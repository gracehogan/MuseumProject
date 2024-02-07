package com.barclays.model.enums;


public enum BookingType {
    SINGLE_ADULT(1),
    SINGLE_CHILD(0.7),
    GROUP_ADULT(0.8),
    GROUP_CHILD(0.5);

    private final double discount;

    public double getDiscount() {
        return discount;
    }

    BookingType(double discount) {
        this.discount = discount;
    }
}
