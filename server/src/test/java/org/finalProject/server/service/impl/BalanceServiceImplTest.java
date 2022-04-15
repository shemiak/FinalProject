package org.finalProject.server.service.impl;

import org.finalProject.server.entity.Account;
import org.finalProject.server.entity.Balance;
import org.finalProject.server.repository.BalanceRepository;
import org.finalProject.server.service.BalanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations="classpath:application-test.properties")
class BalanceServiceImplTest {

    @Autowired
    BalanceService balanceService;

    @MockBean
    BalanceRepository balanceRepository;

    @MockBean
    Account account;

    @Test
    void getBalance() {
        final String cardNumber = "123";
        BigDecimal balance = BigDecimal.valueOf(190965);
        Mockito.when(balanceRepository.findBalanceByAccountCardNumber(cardNumber)).thenReturn(Optional.of(new Balance(1L, account, balance)));
        assertThat(balanceService.getBalance(cardNumber).getBalance()).isEqualTo(balance);
    }
}