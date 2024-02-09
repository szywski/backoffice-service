package pl.mikroserwisy.backofficeservice.model;



import java.util.ArrayList;
import java.util.List;

public class BackofficeModel {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    //default constructor
    public BackofficeModel() {
    }

    public BackofficeModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BackofficeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
