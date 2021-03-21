package ru.stud.minibankgateway.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientNumber {
    @NotNull(message = "clientNumber may not be null")
    @Size(min=4, max = 10)
    private String clientNumber;

}