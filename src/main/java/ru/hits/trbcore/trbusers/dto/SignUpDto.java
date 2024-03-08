package ru.hits.trbcore.trbusers.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
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
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;
}
