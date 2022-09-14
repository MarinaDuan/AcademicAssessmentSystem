package model;

public class Course {
    private String courseCode;
    private String courseName;
    private int instructorId;
    private int assessmentId;
    private int studentId;

    public Course(int studentId, String courseCode, String courseName) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Course(String courseCode, int instructorId, int assessmentId) {
        this.courseCode = courseCode;
        this.instructorId = instructorId;
        this.assessmentId = assessmentId;
    }

    public Course(String courseCode, String courseName, int instructorId) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
    }

    public Course(int studentId, String courseCode, String courseName, int instructorId, int assessmentId) {
        this.studentId= studentId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.assessmentId = assessmentId;
    }

    public Course(String courseCode, String courseName, int instructorId, int assessmentId) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.assessmentId = assessmentId;
    }

    public Course(String courseCode, String courseName, int instructorId, int assessmentId, int studentId) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.assessmentId = assessmentId;
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessId) {
        this.assessmentId = assessId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructorId=" + instructorId +
                ", assessId=" + assessmentId +
                '}';
    }
}
