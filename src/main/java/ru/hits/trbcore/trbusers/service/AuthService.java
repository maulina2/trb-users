package ru.hits.trbcore.trbusers.service;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hits.trbcore.trbusers.dto.IdentDto;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClientRepository clientRepository;

    private final OfficerRepository officerRepository;

    public UUID identOfficer(@Valid @RequestBody IdentDto identDto) {

       return clientRepository.findClientByEmailAndPassword(identDto.getEmail(), identDto.getPassword()).getId();
    }

    public UUID identClient(@Valid @RequestBody IdentDto identDto) {
        return officerRepository.findOfficerByEmailAndPassword(identDto.getEmail(), identDto.getPassword()).getId();
    }

}
