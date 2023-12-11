package org.example.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.api.controller.base.ApiLibrary;
import org.example.api.dto.RequestBookDto;
import org.example.api.dto.ResponseBookDto;
import org.example.api.dto.ResponseStatusBookDto;
import org.example.api.service.ApiLibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiLibrary.BASE_URL)
@RequiredArgsConstructor
public class ApiLibraryController implements ApiLibrary {

    private final ApiLibraryService apiLibraryService;

    @Override
    @Operation(summary = "Получить список книг")
    @GetMapping(value = "/all", produces = "application/json")
    public @ResponseBody List<ResponseBookDto> getAll() {
        return apiLibraryService.getAll();
    }

    @Override
    @Operation(summary = "Добавить книгу")
    @PostMapping(value = "/add", produces = "application/json")
    public @ResponseBody ResponseBookDto add(@RequestBody RequestBookDto requestBookDto) {
        return apiLibraryService.add(requestBookDto);

    }

    @Override
    @PutMapping(value = "update")
    @Operation(summary = "Обновить информацию о книге")
    public void update(@RequestBody RequestBookDto requestBookDto) {
        apiLibraryService.update(requestBookDto);
    }

    @Override
    @Operation(summary = "Узнать статус книги")
    @GetMapping(value = "/status/{id}", produces = "application/json")
    public @ResponseBody ResponseStatusBookDto getStatus(@PathVariable(name = "id") int id) {
        return apiLibraryService.getStatus(id);
    }
}
