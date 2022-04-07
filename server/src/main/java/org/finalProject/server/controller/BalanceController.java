package org.finalProject.server.controller;

import lombok.RequiredArgsConstructor;
import org.finalProject.server.dto.BalanceDTO;
import org.finalProject.server.service.impl.BalanceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceServiceImpl balanceService;

    @ResponseBody
    @GetMapping("/balance")
    public ResponseEntity<BalanceDTO> getBalance() {
        return ResponseEntity.ok(balanceService.getBalance("default"));
    }
}
