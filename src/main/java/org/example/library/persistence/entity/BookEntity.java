package org.example.library.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.util.Objects;

@KeySpace("book")
@Builder
@Getter
@Setter
public class BookEntity {

    @Id
    private Integer id;
    private String title;
    private Integer numberShelf;
    private String statusBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(numberShelf, that.numberShelf) && Objects.equals(statusBook, that.statusBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, numberShelf, statusBook);
    }
}
