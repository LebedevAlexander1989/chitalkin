package org.example.library.api.dto;


import lombok.*;
import org.example.library.core.domain.StatusBook;

@Builder
public record ResponseBookDto(
        Integer id,
        String title,
        Integer numberShelf,
        StatusBook status)
{

    @Override
    public String toString() {
        return "ResponseBookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberShelf=" + numberShelf +
                ", statusBook=" + status +
                '}';
    }
}
