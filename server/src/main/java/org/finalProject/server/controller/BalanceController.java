package org.finalProject.server.controller;

import lombok.RequiredArgsConstructor;
import org.finalProject.server.dto.BalanceDto;
import org.finalProject.server.dto.ErrorDto;
import org.finalProject.server.exception.BalanceNotFoundException;
import org.finalProject.server.service.impl.BalanceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceServiceImpl balanceService;

    @GetMapping("/balance")
    public ResponseEntity<BalanceDto> getBalance(@AuthenticationPrincipal UserDetails details) {
        return ResponseEntity.ok(balanceService.getBalance(details.getUsername()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({BalanceNotFoundException.class})
    public ResponseEntity<ErrorDto> handleBalanceNotFound() {
        return new ResponseEntity<>(new ErrorDto("This account doesn't have balance"), HttpStatus.NOT_FOUND);
    }
}
