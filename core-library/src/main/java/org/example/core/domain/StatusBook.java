package org.example.core.domain;

public enum StatusBook {

    BOOKED("забронирована"),
    FREE("свободна"),
    ON_READING("на прочтении");

    private String description;

    StatusBook(String description) {
        this.description = description;
    }
}
