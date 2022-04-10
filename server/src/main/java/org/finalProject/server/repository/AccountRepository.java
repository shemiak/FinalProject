package org.finalProject.server.repository;

import org.finalProject.server.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findAccountByCardNumber(String cardNumber);
}
