package org.example.library.persistence.service.impl;

import org.example.persistence.entity.BookEntity;
import org.example.persistence.repository.BookRepository;
import org.example.persistence.service.BookEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookEntityServiceImpl implements BookEntityService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookEntityServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity add(BookEntity entity) {
        return bookRepository.save(entity);
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

    @Override
    public BookEntity findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
