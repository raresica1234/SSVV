package ssvv.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ssvv.example.domain.Assignment;
import ssvv.example.domain.Grade;
import ssvv.example.domain.Pair;
import ssvv.example.domain.Student;
import ssvv.example.repository.AbstractCRUDRepository;
import ssvv.example.repository.NotaRepository;
import ssvv.example.repository.StudentRepository;
import ssvv.example.repository.TemaRepository;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab4Test {

	static AbstractCRUDRepository<String, Student> studentRepo;
	static AbstractCRUDRepository<String, Assignment> assignmentRepo;
	static AbstractCRUDRepository<Pair<String, String>, Grade> gradeRepo;

	static Service service;

	@BeforeAll
	static void init() {
		studentRepo = new StudentRepository(new StudentValidator());
		assignmentRepo = new TemaRepository(new TemaValidator());
		gradeRepo = new NotaRepository(new NotaValidator());

		service = new Service(studentRepo, assignmentRepo, gradeRepo);
	}

	@Test
	void testAddStudent() {
		int result = service.saveStudent("0", "Comsa Filip", 932);

		assertEquals(1, result);

		studentRepo.delete("0");
	}

	@Test
	void testAddAssignment() {
		int result = service.saveAssignment("0", "???????????????", 3, 2);

		assertEquals(1, result);

		assignmentRepo.delete("0");
	}

	@Test
	void testAddGrade() {
		service.saveStudent("0", "Comsa Filip", 932);
		service.saveAssignment("0", "???????????????", 3, 2);

		int result = service.saveGrade("0", "0", 5, 2, "pune mana si invata mai baiete");

		assertEquals(1, result);

		gradeRepo.delete(new Pair<>("0", "0"));
	}

	@Test
	void testAll() {
		Student student = new Student("0", "Comsa Filip", 932);
		Assignment assignment = new Assignment("0", "???????????????", 3, 2);
		Grade grade = new Grade(new Pair<>("0", "0"), 7.5, 2, "pune mana si invata mai baiete");

		assertEquals(1, service.saveStudent("0", "Comsa Filip", 932));
		assertEquals(1, service.saveAssignment("0", "???????????????", 3, 2));
		assertEquals(1, service.saveGrade("0", "0", 5, 2, "pune mana si invata mai baiete"));

		assertEquals(service.findAllStudents().iterator().next(), student);
		assertEquals(service.findAllAssignments().iterator().next(), assignment);
		assertEquals(service.findAllGrades().iterator().next(), grade);


		studentRepo.delete("0");
		assignmentRepo.delete("0");
		gradeRepo.delete(new Pair<>("0", "0"));

	}
}
