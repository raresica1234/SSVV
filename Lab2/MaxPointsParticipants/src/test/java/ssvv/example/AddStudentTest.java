package ssvv.example;

import org.junit.jupiter.api.Test;
import ssvv.example.domain.Student;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddStudentTest {
	@Test
	void testAddStudentEC() {
		Student student1 = new Student("0", "Ion", 23);
		Student student2 = new Student("2", "Maria", 922);
		Student student3 = new Student("127373212", "Test", 1381);

		StudentValidator studentValidator = new StudentValidator();

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student1);
		});

		assertDoesNotThrow(() -> {
			studentValidator.validate(student2);
		});

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student3);
		});
	}

	@Test
	void testAddStudentBVA() {
		Student student1 = new Student("0", "Ion", 109);
		Student student2 = new Student("0", "Ion", 110);
		Student student3 = new Student("0", "Ion", 111);
		Student student4 = new Student("0", "Ion", 938);
		Student student5 = new Student("0", "Ion", 939);
		Student student6 = new Student("0", "Ion", 940);

		StudentValidator studentValidator = new StudentValidator();

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student1);
		});

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student2);
		});

		assertDoesNotThrow(() -> {
			studentValidator.validate(student3);
		});

		assertDoesNotThrow(() -> {
			studentValidator.validate(student4);
		});

		assertDoesNotThrow(() -> {
			studentValidator.validate(student5);
		});

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student6);
		});

	}
}
