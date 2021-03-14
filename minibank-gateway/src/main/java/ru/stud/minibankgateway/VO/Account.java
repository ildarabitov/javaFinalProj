package ru.stud.minibankgateway.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long accountId;
    private Long clientNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String balance;
    private Long clientId;
    private String cardIdentifier;
}
