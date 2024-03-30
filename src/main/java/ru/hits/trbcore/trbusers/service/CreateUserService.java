package ru.hits.trbcore.trbusers.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.trbcore.trbusers.dto.SignUpDto;
import ru.hits.trbcore.trbusers.dto.UserDto;
import ru.hits.trbcore.trbusers.entity.User;
import ru.hits.trbcore.trbusers.exception.ConflictException;
import ru.hits.trbcore.trbusers.mapper.UserMapper;
import ru.hits.trbcore.trbusers.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final FindUserService findUserService;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public UserDto createUser(SignUpDto signUpDto) throws FirebaseAuthException {

        checkDoubleClientEmail(signUpDto.getEmail());
        User user = userMapper.newDtoToEntity(signUpDto);
        var password = passwordEncoder.encode(signUpDto.getPassword());
        user.setPassword(password);

        User officer = findUserService.findUser(signUpDto.getWhoCreated());
        user.setWhoCreated(officer);
        user = userRepository.save(user);
        createUserInFireBase(user);

        return userMapper.entityToDto(user);
    }


    private void checkDoubleClientEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ConflictException("Пользователь с такой почтой уже существует");
        }
    }

    private void createUserInFireBase(User user) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setEmailVerified(false)
                .setPassword(user.getPassword());

        Map<String, Object> claims = new HashMap<>();
        claims.put("officer", user.isOfficer());
        claims.put("client", user.isClient());
        claims.put("id", user.getId());
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        FirebaseAuth.getInstance().setCustomUserClaims(userRecord.getUid(), claims);
    }

}
