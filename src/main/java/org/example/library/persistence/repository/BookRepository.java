package org.example.library.persistence.repository;

import org.example.library.persistence.entity.BookEntity;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends KeyValueRepository<BookEntity, Integer> {

}
