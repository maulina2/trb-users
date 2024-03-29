package ru.hits.trbcore.trbusers.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindUserService {

    private final UserRepository userRepository;

    User findUser(UUID clientId) {
        return userRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException
                        ("Пользователь не найден."));
    }

}
