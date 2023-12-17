package org.example.library.core.domain;

public enum StatusBook {

    BOOKED("забронирована"),
    FREE("свободна"),
    ON_READING("на прочтении");

    private String status;

    StatusBook(String status) {
        this.status = status;
    }
}
