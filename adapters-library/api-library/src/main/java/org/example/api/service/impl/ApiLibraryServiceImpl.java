package org.example.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.RequestBookDto;
import org.example.api.dto.ResponseBookDto;
import org.example.api.dto.ResponseStatusBookDto;
import org.example.api.service.ApiLibraryService;
import org.example.core.domain.StatusBook;
import org.example.core.dto.BookDto;
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
        BookDto bookDto = bookService.add(modelMapper.map(requestBookDto, BookDto.class));
        return modelMapper.map(bookDto, ResponseBookDto.class);
    }

    @Override
    public void update(RequestBookDto requestBookDto) {
        bookService.update(modelMapper.map(requestBookDto, BookDto.class));
    }

    @Override
    public ResponseStatusBookDto getStatus(int id) {
        return new ResponseStatusBookDto(StatusBook.valueOf(bookService.getStatus(id)));
    }
}
