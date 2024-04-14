package ru.hits.trbcore.trbusers.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hits.trbcore.trbusers.entity.enumeration.Sex;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private LocalDate birthDate;

    private String email;

    private String phoneNumber;

    private Boolean isClient;

    private Boolean isOfficer;

    private String address;

    private String passportNumber;

    private String passportSeries;

    private Boolean isBlocked;

    private UserDto whoBlocked;

    private UserDto whoCreated;

    @Enumerated(EnumType.STRING)
    private Sex sex;
}
