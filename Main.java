package main;
import util.*;
import java.util.Scanner;
    //check if the information is valid
public class Main {
    private static boolean checkFirstName(String input) {
        return input.matches("[A-Z][a-zA-Z]*");
    }

    private static boolean checkLastName(String input) {
        return input.matches("[A-Z][a-zA-Z.]*");
    }

    private static boolean checkPID(String input) {
        return input.matches("[1-9][0-9]{6}");
    }

    private static boolean checkGrade(String input) {
        try {
            double score = Double.parseDouble(input);
            return score >= 0 && score <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        Scanner keyboard = new Scanner(System.in);
            //prompts user for first student input
        System.out.println("Enter students (firstName lastName PID grade). Type 'DONE' when finished.");

        while (true) {
            String input = keyboard.nextLine().trim();
            if (input.equalsIgnoreCase("DONE")) break;
            //invalidates invalid format
            String[] tokens = input.split(" ");
            if (tokens.length != 4) {
                System.out.println("Invalid format. Try again.");
                continue;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];
            String pidStr = tokens[2];
            String gradeStr = tokens[3];

            if (!checkFirstName(firstName) || !checkLastName(lastName) || !checkPID(pidStr) || !checkGrade(gradeStr)) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            int pid = Integer.parseInt(pidStr);
            double score = Double.parseDouble(gradeStr);
            Grade grade = new Grade(score);
            Student student = new Student(firstName, lastName, pid, grade);
            gradebook.addStudent(student);
        }

        System.out.println("Gradebook loaded. Enter commands (display, average, median, quit):");
            //prints out final information
        while (true) {
            String command = keyboard.nextLine().trim().toLowerCase();
            if (command.equals("quit")) break;
            if (command.equals("display")) gradebook.tabulateScores();
            else if (command.equals("average")) System.out.printf("Average Score: %.2f\n", gradebook.calculateAvg());
            else if (command.equals("median")) System.out.printf("Median Score: %.2f\n", gradebook.calculateMedian());
            else System.out.println("Invalid command.");
        }

    }
}
