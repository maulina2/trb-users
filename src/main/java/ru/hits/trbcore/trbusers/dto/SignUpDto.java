package ru.hits.trbcore.trbusers.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import ru.hits.trbcore.trbusers.entity.enumeration.Sex;

import java.time.LocalDate;

public class SignUpDto {

    private String firstName;

    private String lastName;

    private String patronymic;

    private LocalDate birthDate;

    private String phoneNumber;

    private String address;

    private String passportNumber;

    private String passportSeries;

    @Enumerated(EnumType.STRING)
    private Sex sex;
}
