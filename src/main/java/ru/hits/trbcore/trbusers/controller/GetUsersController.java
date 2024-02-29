package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.service.GetUsersService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Информация о пользователях")
public class GetUsersController {
    private final GetUsersService getUsersService;
    @Operation(summary = "Получить информацию о клиенте.")
    @GetMapping("/client-info")
    ClientDto getClientInfo (@Valid @RequestParam UUID clientId) {

       return getUsersService.getClientInfo(clientId);
    }
}
