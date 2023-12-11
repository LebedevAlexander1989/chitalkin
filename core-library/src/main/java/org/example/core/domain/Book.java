package org.example.core.domain;

import lombok.*;

@Getter
@Setter
public class Book {
    private Integer id;
    private String name;
    private Integer numberShelf;
    private StatusBook statusBook;
}
