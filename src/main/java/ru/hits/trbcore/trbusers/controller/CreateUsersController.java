package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.dto.OfficerDto;
import ru.hits.trbcore.trbusers.dto.SignUpDto;
import ru.hits.trbcore.trbusers.service.CreateUserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Создание пользователей")
public class CreateUsersController {

    private final CreateUserService createUserService;

    @Operation(summary = "Зарегистрировать клиента")
    @PostMapping("/create-client")
    ClientDto createClient (@Valid @RequestBody SignUpDto signUpDto) {

       return createUserService.createClient(signUpDto);
    }

    @Operation(summary = "Зарегистрировать сотрудника")
    @PostMapping("/create-officer")
    OfficerDto createOfficer(@Valid @RequestBody SignUpDto signUpDto) {

        return createUserService.createOfficer(signUpDto);
    }

}
