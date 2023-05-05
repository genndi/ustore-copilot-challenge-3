package re.usto.copilot.challenge.api.controller.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import re.usto.copilot.challenge.api.controller.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
