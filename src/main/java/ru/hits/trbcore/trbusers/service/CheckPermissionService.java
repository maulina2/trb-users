package ru.hits.trbcore.trbusers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.ForbiddenException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckPermissionService {

    private final FindUserService findUserService;

    public User checkPermission(UUID userId) {
        User user = findUserService.findUser(userId);
        if (!user.isOfficer()) {
            throw new ForbiddenException("У вас недостаточно прав");
        }
        return user;
    }
}
