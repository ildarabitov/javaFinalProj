package ru.stud.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stud.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
     Account findByAccountId(Long accountId);
     Account findByCardIdentifier(String cardIdentifier);
     Account findByClientNumber(String cardIdentifier);
}
