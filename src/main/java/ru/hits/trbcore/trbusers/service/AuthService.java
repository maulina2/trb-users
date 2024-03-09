package ru.hits.trbcore.trbusers.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hits.trbcore.trbusers.dto.IdentDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.exception.UnauthorizedException;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final OfficerRepository officerRepository;

    public UUID identOfficer(@Valid @RequestBody IdentDto identDto) {

      Officer officer = officerRepository.findOfficerByEmail(identDto.getEmail())
                .orElseThrow(() -> new NotFoundException("Сотрудник c такой почтой не найден."));

        if (!passwordEncoder.matches(identDto.getPassword(), officer.getPassword())) {
            throw new UnauthorizedException("Некорректная почта и/или пароль.");
        }
        return officer.getId();
    }

    public UUID identClient(@Valid @RequestBody IdentDto identDto) {
        Client client = clientRepository.findClientByEmail(identDto.getEmail())
                .orElseThrow(() -> new NotFoundException("Клиент с такой почтой не найден."));

        if (!passwordEncoder.matches(identDto.getPassword(), client.getPassword())) {
            throw new UnauthorizedException("Некорректная почта и/или пароль.");
        }
        return client.getId();
    }

}
