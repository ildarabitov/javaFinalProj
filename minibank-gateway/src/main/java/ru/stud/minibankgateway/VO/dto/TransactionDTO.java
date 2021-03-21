package ru.stud.minibankgateway.VO.dto;

import io.micrometer.core.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stud.minibankgateway.VO.util.OperationType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    @Size(min=19, max=19, message=" cardIdentifier must be equal to 20 characters")
    private String cardIdentifier;
    @NotNull
    private Double balance;
    @NotNull
    private OperationType operationType;
}
