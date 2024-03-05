package ru.hits.trbcore.trbusers.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ru.hits.trbcore.trbusers.entity.enumeration.Sex;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Officer {
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

    @ManyToOne
    private Officer whoBlocked;

    @ManyToOne
    private Officer whoCreated;

    @OneToMany(mappedBy = "whoCreated")
    private List<Client> createdClients;

    @OneToMany(mappedBy = "whoBlocked")
    private List<Client> blockedClients;

    @OneToMany(mappedBy = "whoCreated")
    private List<Officer> createdOfficers;

    @OneToMany(mappedBy = "whoBlocked")
    private List<Officer> blockedOfficers;

    @Enumerated(EnumType.STRING)
    private Sex sex;
}
