package org.example.library.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {

    private int id;
    private String name;
}
