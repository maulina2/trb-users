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
public class OfficerDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private LocalDate birthDate;

    private String phoneNumber;

    private String address;

    private String passportNumber;

    private String passportSeries;

    private boolean isBlocked;

    private UUID whoBlocked;

    private UUID whoCreated;

    @Enumerated(EnumType.STRING)
    private Sex sex;
}
