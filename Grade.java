package util;

// represents a student's grade
public class Grade {
    private double score;
    private String letterGrade;

    // converts score to letter grade
    private static String convertScoreToLetter(double score) {
        if (score >= 95) return "A+";
        else if (score >= 93) return "A";
        else if (score >= 90) return "A-";
        else if (score >= 87) return "B+";
        else if (score >= 83) return "B";
        else if (score >= 80) return "B-";
        else if (score >= 77) return "C+";
        else if (score >= 73) return "C";
        else if (score >= 70) return "C-";
        else if (score >= 67) return "D+";
        else if (score >= 63) return "D";
        else if (score >= 60) return "D-";
        else return "F";
    }

    // constructor with validation
    public Grade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        this.score = score;
        this.letterGrade = convertScoreToLetter(score);
    }

    // gets score
    public double getScore() {
        return score;
    }

    // gets letter grade
    public String getLetterGrade() {
        return letterGrade;
    }

    // string representation
    @Override
    public String toString() {
        return score + " (" + letterGrade + ")";
    }
}
