package ru.stud.account.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long clientNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private Double balance;
    private Long clientId;
    private String cardIdentifier;
}

