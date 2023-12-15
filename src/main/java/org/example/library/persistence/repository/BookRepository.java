package org.example.library.persistence.repository;

import org.example.persistence.entity.BookEntity;
import org.example.persistence.interceptor.InterceptorRepository;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends KeyValueRepository<BookEntity, Integer>, InterceptorRepository {

}
