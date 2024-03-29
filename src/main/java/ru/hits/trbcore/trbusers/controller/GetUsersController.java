package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.hits.trbcore.trbusers.dto.PageDto;
import ru.hits.trbcore.trbusers.dto.UserDto;
import ru.hits.trbcore.trbusers.service.GetUsersService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Информация о пользователях")
public class GetUsersController {

    private final GetUsersService getUsersService;

    @Operation(summary = "Получить информацию о клиенте")
    @GetMapping("/client-info")
    UserDto getClientInfo(@Valid @RequestParam UUID clientId) {

       return getUsersService.getClientInfo(clientId);
    }

    @Operation(summary = "Получить список клиентов")
    @PostMapping("/client-page")
    Page<UserDto> getClients(@RequestBody @Valid PageDto pageDto) {

        return getUsersService.getClientPage(pageDto);
    }

}
