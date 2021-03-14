package ru.stud.minibankgateway.VO.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeOverBalance {
    private String operation;
    private String status;
    private String cardIdentifier;
    private String transactionIdentifier;
}
