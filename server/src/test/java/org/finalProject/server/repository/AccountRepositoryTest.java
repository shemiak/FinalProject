package org.finalProject.server.repository;

import org.finalProject.server.entity.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testTableAccount() {
        String cardNumber = "134";
        String pinCode = "1345";
        Long id = 1L;

        entityManager.persist(new Account(cardNumber, pinCode));
        Account account = accountRepository.findAccountByCardNumber(cardNumber).orElseThrow();
        assertThat(account.getId()).isEqualTo(id);
        assertThat(account.getCardNumber()).isEqualTo(cardNumber);
        assertThat(account.getPinCode()).isEqualTo(pinCode);
    }
}