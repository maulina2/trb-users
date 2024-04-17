package ru.hits.trbcore.trbusers.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hits.trbcore.trbusers.dto.IdentDto;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public UUID identUser(@Valid @RequestBody IdentDto identDto) {

        User user = userRepository.findUserByEmailAndPassword(identDto.getEmail(), identDto.getPassword())
                .orElseThrow(() -> new NotFoundException
                        ("Пользователь не найден."));
        return user.getId();
    }

}