package ssvv.example.repository;

import ssvv.example.domain.*;
import ssvv.example.validation.*;

public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Grade> {
    public NotaRepository(Validator<Grade> validator) {
        super(validator);
    }
}
