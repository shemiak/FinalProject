INSERT INTO account(CARD_NUMBER, PIN_CODE)
values ('123', '$2a$10$yjduPyzX6FWMIB1IHixbyOXa6gRlq79WfR6JgnGUOKzF5mj0Yuboe'), -- pin_code : 1234
       ('1234', '$2a$10$jLioWf7kZNu0LkIbLEQ6C.GWMFeuaNYkFybVd4KyyHKzoeMdXxpSe'); -- pin_code : 4321

INSERT INTO balance(BALANCE, ACCOUNT_ID)
values (10000, 1),
       (15000, 2);