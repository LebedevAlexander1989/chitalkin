package org.example.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.example.api.controller.base.ApiLibrary;
import org.example.api.dto.RequestBookDto;
import org.example.api.dto.ResponseBookDto;
import org.example.api.dto.ResponseStatusBookDto;
import org.example.api.service.ApiLibraryService;
import org.springframework.http.MediaType;
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
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Добавление книги на полку",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = RequestBookDto.class),
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "name": "Игрок",
                                              "numberShelf": 1,
                                              "status": "FREE"
                                            }
                                            """,
                                    summary = "Пример запроса на добавление книги"),
                    }))
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
