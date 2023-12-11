package org.example.api.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;
import org.example.core.domain.StatusBook;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestBookDto {

    @Parameter(name = "id", description = "Уникальный идентификатор")
    private Integer id;
    @Parameter(name = "Название книги")
    private String name;
    @Parameter(name = "Номер полки")
    private Integer numberShelf;
    @Parameter(name = "Статус книги")
    private StatusBook status;

}
