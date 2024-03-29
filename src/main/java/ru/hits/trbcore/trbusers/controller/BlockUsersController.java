package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.trbcore.trbusers.dto.BlockClientDto;
import ru.hits.trbcore.trbusers.service.BlockUsersService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Блокировка пользователей")
public class BlockUsersController {

    private final BlockUsersService blockUsersService;

    @Operation(summary = "Заблокировать клиента")
    @PostMapping("/block-client")
    void blockClientInfo(@Valid @RequestBody BlockClientDto blockClientDto) {

         blockUsersService.blockClient(blockClientDto);
    }
}
