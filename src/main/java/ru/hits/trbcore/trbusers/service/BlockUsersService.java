package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.mapper.ClientMapper;
import ru.hits.trbcore.trbusers.mapper.OfficerMapper;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlockUsersService {

    private final ClientMapper clientMapper;
    private final OfficerMapper officerMapper;
    private final ClientRepository clientRepository;
    private final OfficerRepository officerRepository;

    @Transactional
    public void blockOfficer(UUID officerId) {

        // Officer officer = officerMapper.newDtoToEntity(signUpDto);
        //officer = officerRepository.save(officer);
        //return officerMapper.entityToDto(officer);
    }

}
