package com.barclays.model.enums;


public enum BookedMuseum {

    PAGES("PAGES"),
    MUSE("MUSE"),
    INNOVATION("Innovation Gallery"),
    BLOB("B.L.O.B");

    private final String name;
    private double fee;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    BookedMuseum(String name) {
        this.name = name;
    }

}
