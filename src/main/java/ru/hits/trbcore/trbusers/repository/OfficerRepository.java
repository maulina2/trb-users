package ru.hits.trbcore.trbusers.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hits.trbcore.trbusers.entity.Officer;

import java.util.UUID;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, UUID> {

   Officer findOfficerByEmailAndPassword(String email, String password);
}
