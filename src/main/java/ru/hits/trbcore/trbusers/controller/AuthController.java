package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.trbcore.trbusers.dto.IdentDto;
import ru.hits.trbcore.trbusers.service.AuthService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Авторизация")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Индентифицировать клиента")
    @PostMapping("/ident-client")
    UUID identClient(@Valid @RequestBody IdentDto identDto) {

      return authService.identClient(identDto);
    }

    @Operation(summary = "Индентифицировать сотрудника")
    @PostMapping("/ident-officer")
    UUID officerId(@Valid @RequestBody IdentDto identDto) {

        return authService.identOfficer(identDto);
    }
}
