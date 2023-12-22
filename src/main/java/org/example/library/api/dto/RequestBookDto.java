package org.example.library.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.library.core.domain.StatusBook;

public record RequestBookDto (
        Integer id,
        @NotEmpty(message = "Title must be not null and not empty")
        String title,
        @NotNull(message = "Number shelf must be not null")
        Integer numberShelf,
        @NotNull(message = "Status book must be not null")
        StatusBook statusBook) {
}
