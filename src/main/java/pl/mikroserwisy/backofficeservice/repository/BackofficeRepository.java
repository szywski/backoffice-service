package pl.mikroserwisy.backofficeservice.repository;

import org.springframework.stereotype.Repository;
import pl.mikroserwisy.backofficeservice.model.BackofficeModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BackofficeRepository {
    private final List<BackofficeModel> backoffices = new ArrayList<>();

    public BackofficeModel addBackoffice (final BackofficeModel backoffice) {
        backoffices.add(backoffice);
        return backoffice;
    }

    public BackofficeModel findById(final Long id) {
        return backoffices.stream()
                .filter(backofficeModel ->
                        backofficeModel.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<BackofficeModel> findAll() {
        return backoffices;
    }

}
