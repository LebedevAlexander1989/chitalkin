package org.example.library.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.library.api.dto.RequestBookDto;
import org.example.library.core.domain.Book;
import org.example.library.core.domain.StatusBook;
import org.example.library.core.service.BookService;
import org.example.library.persistence.entity.BookEntity;
import org.example.library.persistence.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(e -> Book.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .numberShelf(e.getNumberShelf())
                        .statusBook(StatusBook.valueOf(e.getStatusBook()))
                        .build())
                .toList();
    }

    @Override
    public Book add(RequestBookDto request) {
        BookEntity entity = bookRepository.save(BookEntity.builder()
                .id(request.id())
                .title(request.title())
                .numberShelf(request.numberShelf())
                .statusBook(request.statusBook().name())
                .build());
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .numberShelf(entity.getNumberShelf())
                .statusBook(StatusBook.valueOf(entity.getStatusBook()))
                .build();
    }

    @Override
    public void update(RequestBookDto request)  {
        Optional<BookEntity> opt = bookRepository.findById(request.id());
        if (opt.isPresent()) {
            BookEntity entity = opt.get();
            entity.setTitle(request.title());
            entity.setNumberShelf(request.numberShelf());
            entity.setStatusBook(request.statusBook().name());
            bookRepository.save(entity);
        }
    }

    @Override
    public String getStatus(int id) {
        Optional<BookEntity> opt = bookRepository.findById(id);
        return opt.map(BookEntity::getStatusBook).orElse(null);
    }
}
