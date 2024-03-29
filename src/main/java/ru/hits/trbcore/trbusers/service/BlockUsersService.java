package ru.hits.trbcore.trbusers.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.BlockUserDto;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.ConflictException;
import ru.hits.trbcore.trbusers.exception.ForbiddenException;
import ru.hits.trbcore.trbusers.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlockUsersService {

    private final UserRepository userRepository;
    private final FindUserService findUserService;

    @Transactional
    public void blockClient(BlockUserDto blockUserDto) throws FirebaseAuthException {

        User user = findUserService.findUser(blockUserDto.getUserId());
        User officer = findUserService.findUser(blockUserDto.getWhoBlocksId());
        user.setBlocked(true);
        user.setWhoBlocked(officer);
        try {
            UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(user.getId().toString())
                    .setDisabled(true);
            FirebaseAuth.getInstance().updateUser(request);
            System.out.println("Пользователь заблокирован");
        } catch (FirebaseAuthException e) {
            System.err.println("Error disabling user: " + e.getMessage());
        }
        userRepository.save(user);
    }

    private void checkSelfBlock(BlockUserDto blockUserDto) {

        if (blockUserDto.getWhoBlocksId() == blockUserDto.getUserId()) {
            throw new ConflictException("Нельзя заблокировать самого себя");
        }
    }

    private void checkPermission(UUID userId) {
        User user = findUserService.findUser(userId);
        if (!user.isOfficer()) {
            throw new ForbiddenException("Блокировать пользователей может только сотрудник");
        }
    }
}
