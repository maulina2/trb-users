package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.BlockClientDto;
import ru.hits.trbcore.trbusers.dto.BlockUserDto;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.ConflictException;
import ru.hits.trbcore.trbusers.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BlockUsersService {

    private final UserRepository userRepository;
    private final FindUserService findUserService;

    @Transactional
    public void blockClient(BlockClientDto blockClientDto) {

        User client = findUserService.findUser(blockClientDto.getClientId());
        //User officer  = findUserService.findOfficer(blockClientDto.getOfficerId());
        client.setBlocked(true);
        // client.setWhoBlocked(officer);
        userRepository.save(client);
    }

    private void checkSelfBlock(BlockUserDto blockOfficerDto) {

        if (blockOfficerDto.getWhoBlocksId() == blockOfficerDto.getUserId()) {
            throw new ConflictException("Нельзя заблокировать самого себя");
        }
    }
}
