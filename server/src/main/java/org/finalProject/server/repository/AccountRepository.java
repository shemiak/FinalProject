package org.finalProject.server.repository;

import org.finalProject.server.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountById(Long id);
}
