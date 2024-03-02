package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.BlockClientDto;
import ru.hits.trbcore.trbusers.dto.BlockOfficerDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

@Service
@RequiredArgsConstructor
public class BlockUsersService {

    private final ClientRepository clientRepository;
    private final OfficerRepository officerRepository;
    private final FindUserService findUserService;

    @Transactional
    public void blockOfficer(BlockOfficerDto blockOfficerDto) {

        Officer officer = findUserService.findOfficer(blockOfficerDto.getOfficerId());
        officer.setBlocked(true);
        officer.setWhoBlocked(blockOfficerDto.getWhoBlocksId());
        officerRepository.save(officer);
    }

    @Transactional
    public void blockClient(BlockClientDto blockClientDto) {

        Client client = findUserService.findClient(blockClientDto.getClientId());
        client.setBlocked(true);
        client.setWhoBlocked(blockClientDto.getOfficerId());
        clientRepository.save(client);
    }

}
