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
import ru.hits.trbcore.trbusers.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BlockUsersService {

    private final UserRepository userRepository;
    private final FindUserService findUserService;
    private final CheckPermissionService checkPermissionService;

    @Transactional
    public void blockClient(BlockUserDto blockUserDto) {

        checkSelfBlock(blockUserDto);
        User user = findUserService.findUser(blockUserDto.getUserId());
        User officer = checkPermissionService.checkPermission(blockUserDto.getWhoBlocksId());

        user.setIsBlocked(true);
        user.setWhoBlocked(officer);
        blockUserInFireBase(user.getId().toString());
        userRepository.save(user);
    }

    private void checkSelfBlock(BlockUserDto blockUserDto) {

        if (blockUserDto.getWhoBlocksId() == blockUserDto.getUserId()) {
            throw new ConflictException("Нельзя заблокировать самого себя");
        }
    }

    private void blockUserInFireBase(String id) {
        try {
            UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(id)
                    .setDisabled(true);
            FirebaseAuth.getInstance().updateUser(request);
            System.out.println("Пользователь заблокирован");
        } catch (FirebaseAuthException e) {
            System.err.println("Error disabling user: " + e.getMessage());
        }

    }

}
