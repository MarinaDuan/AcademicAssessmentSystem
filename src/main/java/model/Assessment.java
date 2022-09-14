package model;

public class Assessment {
    private int assessmentId;
    private int studentId;
    private String courseCode;
    private int quiz1;
    private int quiz2;
    private int quiz3;
    private int quiz4;
    private int quiz5;
    private int assignment1;
    private int assignment2;
    private int assignment3;
    private int midExam;
    private int finalExam;

    public Assessment(int studentId, String courseCode, int quiz1, int quiz2, int quiz3, int quiz4, int quiz5,
                      int assignment1, int assignment2, int assignment3, int midExam, int finalExam) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.quiz5 = quiz5;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.midExam = midExam;
        this.finalExam = finalExam;
    }

    public Assessment(int assessmentId, int studentId, String courseCode, int quiz1, int quiz2, int quiz3, int quiz4,
                      int quiz5, int assignment1, int assignment2, int assignment3, int midExam, int finalExam) {
        this.assessmentId = assessmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.quiz5 = quiz5;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.midExam = midExam;
        this.finalExam = finalExam;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(int quiz1) {
        this.quiz1 = quiz1;
    }

    public int getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(int quiz2) {
        this.quiz2 = quiz2;
    }

    public int getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(int quiz3) {
        this.quiz3 = quiz3;
    }

    public int getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(int quiz4) {
        this.quiz4 = quiz4;
    }

    public int getQuiz5() {
        return quiz5;
    }

    public void setQuiz5(int quiz5) {
        this.quiz5 = quiz5;
    }

    public int getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(int assignment1) {
        this.assignment1 = assignment1;
    }

    public int getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(int assignment2) {
        this.assignment2 = assignment2;
    }

    public int getAssignment3() {
        return assignment3;
    }

    public void setAssignment3(int assignment3) {
        this.assignment3 = assignment3;
    }

    public int getMidExam() {
        return midExam;
    }

    public void setMidExam(int midExam) {
        this.midExam = midExam;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }
}
