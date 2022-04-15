package org.finalProject.server.controller;

import org.finalProject.server.dto.BalanceDto;
import org.finalProject.server.service.impl.BalanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BalanceController.class)
class BalanceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserDetailsService accountDetailsService;

    @MockBean
    private BalanceServiceImpl balanceService;

    private final String balanceJson = Files.readString(new ClassPathResource("balance.json").getFile().toPath());

    BalanceControllerTest() throws IOException {
    }

    @WithMockUser
    @Test
    void getBalance() throws Exception {
        BigDecimal balance = BigDecimal.valueOf(10000.00).setScale(2);
        Mockito.when(balanceService.getBalance(Mockito.any())).thenReturn(new BalanceDto(balance));
        mvc.perform(get("/balance").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(balanceJson));
    }
}