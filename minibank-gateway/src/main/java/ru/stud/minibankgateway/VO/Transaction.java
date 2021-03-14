package ru.stud.minibankgateway.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stud.minibankgateway.VO.util.OperationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String cardIdentifier;
    private Double balance;
    private OperationType operationType;
    private String transactionIdentifier;
}
