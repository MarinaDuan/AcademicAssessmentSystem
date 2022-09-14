package DAO;

import model.Course;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends DAO{
    private static final String INSERT_COURSE="INSERT INTO courses"+" (courseCode, courseName, instructorId," +
            "assessmentId) VALUES (?,?,?,?);";
    private static final String SELECT_ALL_COURSES = "SELECT * FROM courses";
    private static final String SELECT_COURSE_BY_Code="SELECT * FROM courses WHERE courseCode = ?;";
    private static final String DELETE_COURSE= "DELETE FROM courses WHERE courseCode = ?;";
    private static final String UPDATE_COURSE= "UPDATE courses SET courseName, instructorId,assessmentId WHERE " +
            "courseCode= ?;";

    private static final String INSERT_COURSE_STUDENT="INSERT INTO courses (studentId, courseCode, courseName) " +
            "VALUES (?,?,?);";
    private static final String UPDATE_COURSE_STUDENT= "UPDATE courses SET studentId, courseName WHERE courseCode= ?;";


    public Course selectCourse(String course_code){
        Course course=null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_Code)) {
            preparedStatement.setString(1, course_code);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String courseCode = rs.getString("courseCode");
                String courseName = rs.getString("courseName");
                int instructorId = rs.getInt("instructorId");
                int assessmentId = rs.getInt("assessmentId");
                course = new Course(courseCode,courseName,instructorId,assessmentId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return course;
    }

    public Course selectCourseForStudent(String course_code){
        Course course=null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_Code)) {
            preparedStatement.setString(1, course_code);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String courseCode = rs.getString("courseCode");
                String courseName = rs.getString("courseName");
                int instructorId = rs.getInt("instructorId");
                int assessmentId = rs.getInt("assessmentId");
                course = new Course(studentId,courseCode,courseName,instructorId,assessmentId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return course;
    }

    public void insertCourse(Course course) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE)) {
            preparedStatement.setString(1, course.getCourseCode());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setInt(3, course.getInstructorId());
            preparedStatement.setInt(4, course.getAssessmentId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void insertCourseForStudent(Course course) throws SQLException {
        System.out.println(INSERT_COURSE_STUDENT);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_STUDENT)) {
            preparedStatement.setInt(1, course.getStudentId());
            preparedStatement.setString(2, course.getCourseCode());
            preparedStatement.setString(3, course.getCourseName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Course> selectAllCourses() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Course> courses = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String courseCode = rs.getString("courseCode");
                String courseName = rs.getString("courseName");
                int instructorId = rs.getInt("instructorId");
                int assessmentId = rs.getInt("assessmentId");
                courses.add(new Course(courseCode,courseName, instructorId,assessmentId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return courses;
    }

    public List<Course> selectAllCoursesForStudent() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String courseCode = rs.getString("courseCode");
                String courseName = rs.getString("courseName");
                int studentId = rs.getInt("studentId");
                courses.add(new Course(studentId,courseCode,courseName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return courses;
    }

    public boolean deleteCourse(String courseCode) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_COURSE);) {
            statement.setString(1, courseCode);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateCourse(Course course) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_COURSE_STUDENT);) {
            System.out.println("updated Course:"+statement);
            //courseName, instructorId,assessmentId
            statement.setString(1, course.getCourseName());
            statement.setInt(2, course.getInstructorId());
            statement.setInt(3, course.getAssessmentId());
            statement.setString(4, course.getCourseCode());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateCourseForStudent(Course course) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_COURSE);) {
            System.out.println("updated Student Course:"+statement);
            //courseName, instructorId,assessmentId
            statement.setString(1, course.getCourseName());
            statement.setInt(2, course.getStudentId());
            statement.setString(3, course.getCourseCode());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
