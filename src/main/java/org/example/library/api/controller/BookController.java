package org.example.library.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.library.api.dto.RequestBookDto;
import org.example.library.api.dto.ResponseBookDto;
import org.example.library.api.dto.ResponseStatusBookDto;
import org.example.library.core.domain.Book;
import org.example.library.core.domain.StatusBook;
import org.example.library.core.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Получить список книг")
    @GetMapping(value = "/all", produces = "application/json")
    public List<ResponseBookDto> getAll() {
        return bookService.getAll()
                .stream()
                .map(b -> ResponseBookDto.builder()
                        .id(b.id())
                        .title(b.title())
                        .numberShelf(b.numberShelf())
                        .statusBook(b.statusBook())
                        .build())
                .toList();
    }

    @Operation(summary = "Добавить книгу")
    @PostMapping(value = "/add", produces = "application/json")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Добавление книги на полку",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = RequestBookDto.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "title": "Игрок",
                                              "numberShelf": 1,
                                              "statusBook": "FREE"
                                            }
                                            """,
                                    summary = "Пример запроса на добавление книги"),
                    }))

    public ResponseBookDto add(@RequestBody @Valid RequestBookDto requestBookDto) {
        Book book = bookService.add(requestBookDto);
        return ResponseBookDto.builder()
                .id(book.id())
                .title(book.title())
                .numberShelf(book.numberShelf())
                .statusBook(book.statusBook())
                .build();
    }

    @PutMapping(value = "update")
    @Operation(summary = "Обновить информацию о книге")
    public void update(@RequestBody @Valid RequestBookDto requestBookDto) {
        bookService.update(requestBookDto);
    }

    @Operation(summary = "Узнать статус книги")
    @GetMapping(value = "/status/{id}", produces = "application/json")
    public ResponseStatusBookDto getStatus(@PathVariable(name = "id") int id) {
        return new ResponseStatusBookDto(StatusBook.valueOf(bookService.getStatus(id)));
    }
}
