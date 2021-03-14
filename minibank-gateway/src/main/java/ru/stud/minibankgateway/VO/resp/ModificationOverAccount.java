package ru.stud.minibankgateway.VO.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModificationOverAccount {
    private String operation;
    private String statusOperation;
    private String cardIdentifier;
}
