package org.chitalkin.ru.adapters.persistence.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookEntity {

    private int id;
    private String name;
}
