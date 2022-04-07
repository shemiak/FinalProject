package org.finalProject.server.repository;

import org.finalProject.server.entity.Balance;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
    Balance findBalanceByAccountCardNumber(String cardNumber);
}