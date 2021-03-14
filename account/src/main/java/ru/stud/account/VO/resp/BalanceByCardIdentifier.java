package ru.stud.account.VO.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceByCardIdentifier {
    private String cardIdentifier;
    private Double balance;

}
