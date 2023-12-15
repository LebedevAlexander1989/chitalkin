package org.example.library.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.core.domain.StatusBook;

@Getter
@Setter
public class RequestBookDto {
    private Integer id;
    private String name;
    private Integer numberShelf;
    private StatusBook status;
}
