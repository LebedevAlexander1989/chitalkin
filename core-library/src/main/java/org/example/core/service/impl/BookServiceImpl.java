package org.example.core.service.impl;

import org.example.core.dto.BookDto;
import org.example.core.service.BookService;
import org.example.persistence.entity.BookEntity;
import org.example.persistence.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(b -> modelMapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public BookDto add(BookDto bookDto) {
        BookEntity entity = bookRepository.save(modelMapper.map(bookDto, BookEntity.class));
        return modelMapper.map(entity, BookDto.class);
    }

    @Override
    public void update(BookDto bookDto) {
        Optional<BookEntity> opt = bookRepository.findById(bookDto.getId());
        if (opt.isPresent()) {
            BookEntity entity = opt.get();
            modelMapper.map(bookDto, entity);
            bookRepository.save(entity);
        }
    }

    @Override
    public String getStatus(int id) {
        Optional<BookEntity> opt = bookRepository.findById(id);
        if (opt.isPresent()) {
            BookEntity entity = opt.get();
            return entity.getStatus();
        }
        return null;
    }
}
