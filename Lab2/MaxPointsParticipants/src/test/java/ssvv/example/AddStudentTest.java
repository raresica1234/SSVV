package ssvv.example;

import org.junit.jupiter.api.Test;
import ssvv.example.domain.Student;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

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
		Student student1 = new Student("0", "Ion", 23);
		Student student2 = new Student("2", "Maria", 922);
		Student student3 = new Student("127373212", "Test", 1381);

		StudentValidator studentValidator = new StudentValidator();

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student1);
		});

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student2);
		});

		assertThrows(ValidationException.class, () -> {
			studentValidator.validate(student3);
		});

	}
}
