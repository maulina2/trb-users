package ru.hits.trbcore.trbusers.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hits.trbcore.trbusers.dto.IdentDto;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.exception.UnauthorizedException;
import ru.hits.trbcore.trbusers.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UUID identUser(@Valid @RequestBody IdentDto identDto) {

        User user = userRepository.findUserByEmail(identDto.getEmail())
                .orElseThrow(() -> new NotFoundException("Сотрудник c такой почтой не найден."));

        if (!passwordEncoder.matches(identDto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Некорректная почта и/или пароль.");
        }
        return user.getId();
    }

}