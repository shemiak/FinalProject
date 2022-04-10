package org.finalProject.server.repository;

import org.finalProject.server.entity.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BalanceRepository extends CrudRepository<Balance, Long> {

    Optional<Balance> findBalanceByAccountCardNumber(String cardNumber);
}