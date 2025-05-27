package util;

// represents a student with personal info and grade
public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    // constructor
    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }

    // sets grade
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    // gets first name
    public String getFirstName() {
        return firstName;
    }

    // gets last name
    public String getLastName() {
        return lastName;
    }

    // gets pid
    public int getPid() {
        return pid;
    }

    // gets grade
    public Grade getGrade() {
        return grade;
    }

    // string representation
    @Override
    public String toString() {
        return String.format("%-12s %-12s %-8d %s",
                firstName, lastName, pid, grade.toString());
    }
}
