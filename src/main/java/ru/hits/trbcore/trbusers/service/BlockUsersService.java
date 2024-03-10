package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.BlockClientDto;
import ru.hits.trbcore.trbusers.dto.BlockOfficerDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.exception.ConflictException;
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

        checkSelfBlock(blockOfficerDto);
        Officer targetOfficer = findUserService.findOfficer(blockOfficerDto.getOfficerId());
        Officer officer = findUserService.findOfficer(blockOfficerDto.getWhoBlocksId());
        targetOfficer.setBlocked(true);
        targetOfficer.setWhoBlocked(officer);
        officerRepository.save(targetOfficer);
    }

    @Transactional
    public void blockClient(BlockClientDto blockClientDto) {

        Client client = findUserService.findClient(blockClientDto.getClientId());
        Officer officer = findUserService.findOfficer(blockClientDto.getOfficerId());
        client.setBlocked(true);
        client.setWhoBlocked(officer);
        clientRepository.save(client);
    }

    private void checkSelfBlock(BlockOfficerDto blockOfficerDto){

        if(blockOfficerDto.getWhoBlocksId() == blockOfficerDto.getOfficerId()){
            throw new ConflictException("Нельзя заблокировать самого себя");
        }
    }
}
