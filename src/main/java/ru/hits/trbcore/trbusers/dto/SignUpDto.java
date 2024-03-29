package ru.hits.trbcore.trbusers.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.hits.trbcore.trbusers.entity.enumeration.Role;
import ru.hits.trbcore.trbusers.entity.enumeration.Sex;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class SignUpDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String patronymic;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;
    @NotNull
    private String passportNumber;

    private String passportSeries;
    @NotNull
    private UUID whoCreated;

    @NotNull
    private String email;

    @NotNull
    @Length(min = 6, max = 30, message = "Длина пароля должна быть между 6 и 30 символами")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
}
