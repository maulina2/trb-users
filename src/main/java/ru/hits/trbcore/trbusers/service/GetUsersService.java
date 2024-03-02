package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.dto.OfficerDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.mapper.ClientMapper;
import ru.hits.trbcore.trbusers.mapper.OfficerMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    private final ClientMapper clientMapper;
    private final OfficerMapper officerMapper;
    private final FindUserService findUserService;

    @Transactional(readOnly = true)
    public ClientDto getClientInfo(UUID clientId) {

        Client client = findUserService.findClient(clientId);
        return clientMapper.entityToDto(client);
    }

    @Transactional(readOnly = true)
    public OfficerDto getOfficerInfo(UUID officerId) {

        Officer officer = findUserService.findOfficer(officerId);
        return officerMapper.entityToDto(officer);
    }
}
