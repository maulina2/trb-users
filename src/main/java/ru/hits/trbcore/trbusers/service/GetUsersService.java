package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.ClientDto;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.mapper.ClientMapper;
import ru.hits.trbcore.trbusers.repository.ClientRepository;

import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDto getClientInfo(UUID clientId) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> {
                    throw new NotFoundException("Пользователь с таким id " + id.toString() + "не найден.");
                });
        return clientMapper.entityToDto(client);
    }

}
