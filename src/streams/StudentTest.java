package streams;

import java.util.Arrays;
import java.util.stream.Collectors;

class Student {
    public static enum Grade {A, B, C, D, F}
    private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Grade grade;
    public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Student(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }
    public String toString() {
        return name + ":" + grade;
    }
}
public class StudentTest {
    public static void main(String[] args) {

        var ls = Arrays.asList(new Student("S1", Student.Grade.A),
                new Student("S2", Student.Grade.A),
                new Student("S3", Student.Grade.B),
                new Student("S4", Student.Grade.C),
                new Student("S5", Student.Grade.F));

        var group = ls.stream()
                .filter(student -> student.getGrade() != Student.Grade.F)
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(group);
    }
}
