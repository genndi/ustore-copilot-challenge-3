package re.usto.copilot.challenge.api.controller.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public record EmployeeForm(
        @NotEmpty
        String name,
        @Email
        String email,
        @CPF
        String cpf,
        @Pattern(regexp = "[0-9]{2}[0-9]{4,5}[0-9]{4}")
        String phone,
        @NotEmpty
        String address,
        @NotEmpty
        String city) implements Serializable {
}
