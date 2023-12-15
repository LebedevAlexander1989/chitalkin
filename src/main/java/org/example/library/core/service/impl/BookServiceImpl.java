package org.example.library.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.library.api.dto.RequestBookDto;
import org.example.library.core.domain.Book;
import org.example.library.core.service.BookService;
import org.example.library.persistence.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final ModelMapper modelMapper;

    @Override
    public List<Book> getAll() {
        return bookEntityService.getAll()
                .stream()
                .map(b -> modelMapper.map(b, Book.class))
                .toList();
    }

    @Override
    public Book add(RequestBookDto request) {
        BookEntity entity = bookEntityService.add(modelMapper.map(book, BookEntity.class));
        return modelMapper.map(entity, Book.class);
    }

    @Override
    public void update(RequestBookDto request)  {
        BookEntity entity = bookEntityService.findById(book.getId());
        if (entity != null) {
            modelMapper.map(book, entity);
            bookEntityService.add(entity);
        }
    }

    @Override
    public String getStatus(int id) {
        BookEntity entity = bookEntityService.findById(id);
        if (entity != null) {
            return entity.getStatus();
        }
        return null;
    }
}
