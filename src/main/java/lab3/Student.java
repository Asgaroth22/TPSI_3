package lab3;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<Double> grades = new ArrayList<>();

    public Student(String firstName, String lastName, String emailAddress) {
        super(firstName, lastName, emailAddress);
    }


    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getGradesAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
            return (sum / grades.size());
    }
}
