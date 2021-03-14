package ru.stud.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stud.client.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByClientNumber(Long clientNumber);
}
