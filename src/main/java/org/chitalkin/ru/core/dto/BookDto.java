package org.chitalkin.ru.core.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookDto {

    private int id;
    private String name;
}
