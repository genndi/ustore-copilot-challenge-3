package re.usto.copilot.challenge.api.controller.model;

import java.io.Serializable;

public record EmployeeForm(
        String name,
        String email,
        String cpf,
        String phone,
        String address,
        String city) implements Serializable {
}
