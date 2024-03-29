package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.PageDto;
import ru.hits.trbcore.trbusers.dto.UserDto;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.mapper.UserMapper;
import ru.hits.trbcore.trbusers.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final FindUserService findUserService;

    @Transactional(readOnly = true)
    public UserDto getClientInfo(UUID clientId) {

        User client = findUserService.findUser(clientId);
        return userMapper.entityToDto(client);
    }

    @Transactional(readOnly = true)
    public Page<UserDto> getClientPage(PageDto pageDto) {

        Pageable pageable = createPageable(pageDto);
        return userRepository.findAll(pageable).map(userMapper::entityToDto);
    }

    private Pageable createPageable(PageDto pageDto) {
        int page = pageDto.getPageNumber();
        int size = pageDto.getPageSize();
        return PageRequest.of(page, size);
    }

}
