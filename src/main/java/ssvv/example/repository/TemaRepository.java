package ssvv.example.repository;

import ssvv.example.domain.Assignment;
import ssvv.example.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Assignment> {
    public TemaRepository(Validator<Assignment> validator) {
        super(validator);
    }
}

