package org.example.library.api.service;

import org.example.api.dto.RequestBookDto;
import org.example.api.dto.ResponseBookDto;
import org.example.api.dto.ResponseStatusBookDto;

import java.util.List;

public interface ApiLibraryService {

    List<ResponseBookDto> getAll();

    ResponseBookDto add(RequestBookDto requestBookDto);

    void update(RequestBookDto requestBookDto);

    ResponseStatusBookDto getStatus(int id);
}
