package org.example.library.api.controller.base;

import org.example.api.dto.RequestBookDto;
import org.example.api.dto.ResponseBookDto;
import org.example.api.dto.ResponseStatusBookDto;

import java.util.List;

public interface ApiLibrary {

    String BASE_URL = "/api";

    List<ResponseBookDto> getAll();

    ResponseBookDto add(RequestBookDto requestBookDto);

    void update(RequestBookDto requestBookDto);

    ResponseStatusBookDto getStatus(int id);
}
