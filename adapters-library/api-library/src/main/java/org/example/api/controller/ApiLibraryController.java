package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.controller.base.ApiLibrary;
import org.example.core.service.BookService;
import org.example.api.dto.ResponseBookDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(ApiLibrary.BASE_URL)
@RequiredArgsConstructor
public class ApiLibraryController implements ApiLibrary {

    private final BookService bookService;
    @Override
    @GetMapping(value = "/all/", produces = "application/json")
    public @ResponseBody List<ResponseBookDto> getAll() {
        return bookService.getAll()
                .stream()
                .map(book -> new ResponseBookDto(book.id(), book.name()))
                .toList();
    }
}
