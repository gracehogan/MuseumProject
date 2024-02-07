package com.barclays.model.enums;


public enum BookedMuseum {

    PAGES("PAGES"),
    MUSE("MUSE"),
    INNOVATION("Innovation Gallery"),
    BLOB("B.L.O.B");

    private final String name;
    BookedMuseum(String name) {
        this.name = name;
    }

}
