package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.dto.OfficerDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.mapper.ClientMapper;
import ru.hits.trbcore.trbusers.mapper.OfficerMapper;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    private final ClientMapper clientMapper;
    private final OfficerMapper officerMapper;
    private final ClientRepository clientRepository;
    private final OfficerRepository officerRepository;

    @Transactional(readOnly = true)
    public ClientDto getClientInfo(UUID clientId) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException
                        ("Пользователь с таким id " + clientId.toString() + " не найден."));
        return clientMapper.entityToDto(client);
    }

    @Transactional(readOnly = true)
    public OfficerDto getOfficerInfo(UUID officerId) {

        Officer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new NotFoundException
                        ("Пользователь с таким id " + officerId.toString() + " не найден."));
        return officerMapper.entityToDto(officer);
    }
}
