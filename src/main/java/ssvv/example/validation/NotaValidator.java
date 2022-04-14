package ssvv.example.validation;
import ssvv.example.domain.Grade;

public class NotaValidator implements Validator<Grade> {
    public void validate(Grade grade) throws ValidationException {
        if (grade.getID().getObject1() == null || grade.getID().equals("")) {
            throw new ValidationException("ID Student invalid! \n");
        }
        if (grade.getID().getObject2() == null || grade.getID().equals("")) {
            throw new ValidationException("ID Tema invalid! \n");
        }
        if (grade.getNota() < 0 || grade.getNota() > 10) {
            throw new ValidationException("Nota invalida! \n");
        }
        if (grade.getSaptamanaPredare() < 0) {
            throw new ValidationException("Saptamana de predare invalida! \n");
        }
    }
}
