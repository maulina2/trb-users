package ru.hits.trbcore.trbusers.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import ru.hits.trbcore.trbusers.entity.enumeration.Sex;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
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
