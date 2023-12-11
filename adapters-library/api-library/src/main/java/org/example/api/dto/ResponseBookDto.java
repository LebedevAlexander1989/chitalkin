package org.example.api.dto;


import lombok.*;
import org.example.core.domain.StatusBook;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseBookDto {
    private long id;
    private String name;
    private int numberShelf;

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
