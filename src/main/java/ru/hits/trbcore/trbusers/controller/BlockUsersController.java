package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.trbcore.trbusers.service.BlockUsersService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Блокировка пользователей")
public class BlockUsersController {

    private final BlockUsersService blockUsersService;

    @Operation(summary = "Заблокировать сотрудника.")
    @PostMapping("/block-officer")
    void blockOfficerInfo(@Valid @RequestParam UUID officerId) {

        // blockUsersService.blockOfficerInfo(officerId);
    }
}
