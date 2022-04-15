package org.finalProject.server.repository;

import org.finalProject.server.entity.Account;
import org.finalProject.server.entity.Balance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
class BalanceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BalanceRepository balanceRepository;

    @Test
    void testTableBalance() {
        String cardNumber = "12345";
        String pinCode = "5678";

        BigDecimal balanceValue = BigDecimal.valueOf(19897876);
        Account account = new Account(cardNumber, pinCode);
        entityManager.persist(account);
        entityManager.persist(new Balance(account, balanceValue));
        Balance balance = balanceRepository.findBalanceByAccountCardNumber(cardNumber).orElseThrow();
        assertThat(balance.getId()).isEqualTo(1L);
        assertThat(balance.getBalance()).isEqualTo(balanceValue);
        assertThat(balance.getAccount()).isEqualTo(account);
    }
}