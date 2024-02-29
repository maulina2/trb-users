package ru.hits.trbcore.trbusers.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.dto.SignUpDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.mapper.ClientMapper;
import ru.hits.trbcore.trbusers.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Transactional
    public ClientDto createClient(SignUpDto signUpDto) {

        Client client = clientMapper.newDtoToEntity(signUpDto);
        client = clientRepository.save(client);
        return clientMapper.entityToDto(client);
    }

}
