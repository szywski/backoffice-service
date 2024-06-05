package pl.mikroserwisy.backofficeservice.client;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import pl.mikroserwisy.backofficeservice.model.Employee;

@HttpExchange
public interface EmployeeClient {

  @GetExchange("/employee/backoffice/{backofficeId}")
  List<Employee> getEmployeesForBackoffice(@PathVariable Long backofficeId);


}
