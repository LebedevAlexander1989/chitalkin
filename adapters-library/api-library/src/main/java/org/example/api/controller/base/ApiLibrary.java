package org.example.api.controller.base;

import org.example.api.dto.ResponseBookDto;

import java.util.List;

public interface ApiLibrary {

    String BASE_URL = "/api";

    List<ResponseBookDto> getAll();
}
