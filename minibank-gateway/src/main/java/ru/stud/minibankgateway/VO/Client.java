package ru.stud.minibankgateway.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @NotNull(message="firstName not be empty")
	private String firstName;
	@NotNull(message="middleNAme not be empty")
	private String middleNAme;
	@NotNull(message="lastName not be empty")
	private String lastName;
	@Size(min=4,  message="ClientNumber must be greater than 4 characters ")
	@Size(max=10, message="ClientNumber must be greater than 10 characters")
	private String clientNumber;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@ApiModelProperty(required = true, example = "2021-08-20")
	@NotNull(message="birthDate not be empty")
	private LocalDate birthDate;
}
