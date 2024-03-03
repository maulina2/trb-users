package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.dto.OfficerDto;
import ru.hits.trbcore.trbusers.dto.PageDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.mapper.ClientMapper;
import ru.hits.trbcore.trbusers.mapper.OfficerMapper;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    private final ClientRepository clientRepository;
    private final OfficerRepository officerRepository;
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

    @Transactional(readOnly = true)
    public Page<ClientDto> getClientPage(PageDto pageDto) {

        Pageable pageable = createPageable(pageDto);
        return clientRepository.findAll(pageable).map(clientMapper::entityToDto);
    }

    @Transactional(readOnly = true)
    public Page<OfficerDto> getOfficerPage(PageDto pageDto) {

        Pageable pageable = createPageable(pageDto);
        return officerRepository.findAll(pageable).map(officerMapper::entityToDto);
    }
    private Pageable createPageable(PageDto pageDto) {
        int page = pageDto.getPageNumber();
        int size = pageDto.getPageSize();
        return PageRequest.of(page, size);
    }


}
