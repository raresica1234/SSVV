package ssvv.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ssvv.example.domain.Assignment;
import ssvv.example.repository.AbstractCRUDRepository;
import ssvv.example.repository.TemaRepository;
import ssvv.example.validation.TemaValidator;
import ssvv.example.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

public class AddAssignmentTest {

	static AbstractCRUDRepository<String, Assignment> temaRepo;

	@BeforeAll
	static void init() {
		temaRepo = new TemaRepository(new TemaValidator());
	}

	@Test
	void path1() {
		assertThrows(ValidationException.class, () -> {
			temaRepo.save(new Assignment("", "", 0, 0));
		});
	}

	@Test
	void path2() {
		assertThrows(ValidationException.class, () -> {
			temaRepo.save(new Assignment("5", "", 0, 0));
		});
	}

	@Test
	void path3() {
		assertThrows(ValidationException.class, () -> {
			temaRepo.save(new Assignment("5", "a", 0, 0));
		});
	}

	@Test
	void path4() {
		assertThrows(ValidationException.class, () -> {
			temaRepo.save(new Assignment("5", "a", 4, 0));
		});
	}

	@Test
	void path5() {
		Assignment assignment = new Assignment("5", "a", 4, 2);
		assertDoesNotThrow(() -> {
			temaRepo.save(assignment);
		});

		assertEquals(temaRepo.findOne(assignment.getID()), assignment);
	}

}
