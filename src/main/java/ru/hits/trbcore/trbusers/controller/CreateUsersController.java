package ru.hits.trbcore.trbusers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.dto.SignUpDto;

@RestController
@RequestMapping("/api/v1/create-users")
@RequiredArgsConstructor
@Tag(name = "Создание пользователей")
public class CreateUsersController {
    @Operation(summary = "Зарегистрировать пользователя.")
    @PostMapping("/sign-up")
    ResponseEntity<SignUpDto> createClient (@Valid @RequestBody SignUpDto signUpDto) {

//        ClientDto fullUserDto = signUpService.userSignUp(signUpDto);
//        HttpHeaders header = new HttpHeaders();
//        header.set("JwtToken", fullUserDto.getJwtToken());
//        return new ResponseEntity<>(fullUserDto.getUserDto(), header, HttpStatus.OK);
        return null;
    }

}
