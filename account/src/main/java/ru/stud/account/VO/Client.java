package ru.stud.account.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private long clientId;
    private String firstName;
    private String middleNAme;
    private String lastName;
    private String clientNumber;
    private LocalDate birthDate;
}
