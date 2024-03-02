package ru.hits.trbcore.trbusers.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hits.trbcore.trbusers.entity.Client;
import ru.hits.trbcore.trbusers.entity.Officer;
import ru.hits.trbcore.trbusers.exception.NotFoundException;
import ru.hits.trbcore.trbusers.repository.ClientRepository;
import ru.hits.trbcore.trbusers.repository.OfficerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindUserService {

    private final ClientRepository clientRepository;
    private final OfficerRepository officerRepository;

    Client findClient(UUID clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException
                        ("Клиент не найден."));
    }

    Officer findOfficer(UUID officerId) {
        return officerRepository.findById(officerId)
                .orElseThrow(() -> new NotFoundException
                        ("Сотрудник не найден."));
    }
}
