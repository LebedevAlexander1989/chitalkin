package org.example.library.core.domain;

import lombok.*;

@Builder
public record Book(
        Integer id,
        String title,
        Integer numberShelf,
        StatusBook statusBook
) {}
