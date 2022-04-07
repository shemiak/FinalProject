package org.finalProject.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class BalanceDTO {
    private BigDecimal balance;
}
