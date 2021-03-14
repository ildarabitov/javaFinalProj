package ru.stud.minibankgateway.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String firstName;
    private String middleNAme;
    private String lastName;
    private Long clientNumber;
}
