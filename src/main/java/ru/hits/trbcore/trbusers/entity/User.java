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
@Table(name = "_user")
public class User {

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

    private String email;

    private String password;

    private boolean isBlocked;

    private boolean isClient;

    private boolean isOfficer;

    @ManyToOne
    private User whoBlocked;

    @ManyToOne
    private User whoCreated;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToMany(mappedBy = "whoCreated")
    private List<User> createdUsers;

    @OneToMany(mappedBy = "whoBlocked")
    private List<User> blockedUsers;

}
