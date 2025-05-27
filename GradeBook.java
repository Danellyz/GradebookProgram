package util;

import java.util.ArrayList;
import java.util.Collections;

// manages a list of students and calculates grade statistics
public class Gradebook {
    private ArrayList<Student> listOfStudents;

    // constructor
    public Gradebook() {
        this.listOfStudents = new ArrayList<>();
    }

    // adds student
    public void addStudent(Student student) {
        listOfStudents.add(student);
    }

    // calculates average score
    public double calculateAvg() {
        if (listOfStudents.isEmpty()) return 0;
        double sum = 0;
        for (Student s : listOfStudents) {
            sum += s.getGrade().getScore();
        }
        return sum / listOfStudents.size();
    }

    // calculates median score
    public double calculateMedian() {
        if (listOfStudents.isEmpty()) return 0;
        ArrayList<Double> scores = new ArrayList<>();
        for (Student s : listOfStudents) {
            scores.add(s.getGrade().getScore());
        }
        Collections.sort(scores);
        int n = scores.size();
        if (n % 2 == 0)
            return (scores.get(n / 2) + scores.get(n / 2 - 1)) / 2.0;
        else
            return scores.get(n / 2);
    }

    // displays all students' scores
    public void tabulateScores() {
        for (Student s : listOfStudents) {
            System.out.printf("%-12s %-12s %-8d %.2f (%s)%n",
                    s.getFirstName(), s.getLastName(),
                    s.getPid(), s.getGrade().getScore(), s.getGrade().getLetterGrade());
        }
    }
}
