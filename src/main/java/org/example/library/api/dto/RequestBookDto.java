package org.example.library.api.dto;

import org.example.library.core.domain.StatusBook;

public record RequestBookDto (
        Integer id,
        String title,
        Integer numberShelf,
        StatusBook statusBook) {
}
