package org.example.persistence.repository;

import org.example.persistence.entity.BookEntity;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends KeyValueRepository<BookEntity, Integer> {

    List<BookEntity> findAll();
}
