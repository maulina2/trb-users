package ru.hits.trbcore.trbusers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hits.trbcore.trbusers.entity.Client;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Client findClientByEmailAndPassword(String email, String password);

}
