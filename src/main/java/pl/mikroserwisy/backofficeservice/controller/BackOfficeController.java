package pl.mikroserwisy.backofficeservice.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mikroserwisy.backofficeservice.client.EmployeeClient;
import pl.mikroserwisy.backofficeservice.model.BackofficeModel;
import pl.mikroserwisy.backofficeservice.repository.BackofficeRepository;

@RestController
@RequestMapping("/backoffice")
public class BackOfficeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BackOfficeController.class);
  @Autowired
  private BackofficeRepository repository;

  @Autowired
  private EmployeeClient employeeClient;

  @PostMapping
  public BackofficeModel add(@RequestBody final BackofficeModel backoffice) {
    LOGGER.info("Backoffice add: {}", backoffice);
    return repository.addBackoffice(backoffice);
  }

  @GetMapping
  public List<BackofficeModel> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public BackofficeModel findById(@PathVariable final Long id) {
    LOGGER.info("Backoffice find: {}", id);
    return repository.findById(id);
  }

  @GetMapping("/with-employees")
  public List<BackofficeModel> findAllWithEmployees() {
    List<BackofficeModel> backofficeModels = repository.findAll();
    backofficeModels.forEach(backofficeModel -> backofficeModel.setEmployees(
        employeeClient.getEmployeesForBackoffice(backofficeModel.getId())));

    return backofficeModels;
  }
}
