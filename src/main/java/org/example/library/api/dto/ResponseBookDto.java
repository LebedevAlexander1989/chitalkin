package org.example.library.api.dto;


import lombok.*;
import org.example.core.domain.StatusBook;

@Getter
@Setter
public class ResponseBookDto {
    private Integer id;
    private String name;
    private Integer numberShelf;
    private StatusBook status;
    @Override
    public String toString() {
        return "ResponseBookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberShelf=" + numberShelf +
                ", status=" + status +
                '}';
    }
}
