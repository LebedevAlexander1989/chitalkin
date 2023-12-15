package org.example.library.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.RequestBookDto;
import org.example.api.dto.ResponseBookDto;
import org.example.api.dto.ResponseStatusBookDto;
import org.example.api.service.ApiLibraryService;
import org.example.core.domain.StatusBook;
import org.example.core.domain.Book;
import org.example.core.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiLibraryServiceImpl implements ApiLibraryService {

    private final BookService bookService;

    private final ModelMapper modelMapper;

    @Override
    public List<ResponseBookDto> getAll() {
        return bookService.getAll()
                .stream()
                .map(b -> modelMapper.map(b, ResponseBookDto.class))
                .toList();
    }

    @Override
    public ResponseBookDto add(RequestBookDto requestBookDto) {
        Book book = bookService.add(modelMapper.map(requestBookDto, Book.class));
        return modelMapper.map(book, ResponseBookDto.class);
    }

    @Override
    public void update(RequestBookDto requestBookDto) {
        bookService.update(modelMapper.map(requestBookDto, Book.class));
    }

    @Override
    public ResponseStatusBookDto getStatus(int id) {
        return new ResponseStatusBookDto(StatusBook.valueOf(bookService.getStatus(id)));
    }
}
