package DAO;

import model.Assessment;
import model.Course;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssessmentDAO extends DAO{

    private static final String INSERT_ASSESSMENT="INSERT INTO assessments"+" (studentId, courseCode, quiz1, quiz2" +
            ", quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, final) VALUES (?,?,?,?,?,?,?,?," +
            "?,?,?,?);";
    private static final String SELECT_ALL_ASSESSMENTS= "SELECT * FROM assessments";
    private static final String SELECT_ASSESSMENT_BY_ID="SELECT * FROM assessments WHERE assessmentId = ?;";
    private static final String DELETE_ASSESSMENT= "DELETE FROM assessments WHERE assessmentId = ?;";
    private static final String UPDATE_ASSESSMENT= "UPDATE assessments SET studentId=?,courseCode=?,quiz1=?,quiz2=?," +
            "quiz3=?,quiz4=?,quiz5=?,assignment1=?,assignment2=?,assignment3=?,midExam=?,finalExam=? " +
            "WHERE assessmentId=?;";


    public void insertAssessment(Assessment assessment) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSESSMENT)) {
            preparedStatement.setInt(1, assessment.getStudentId());
            preparedStatement.setString(2, assessment.getCourseCode());
            preparedStatement.setInt(3, assessment.getQuiz1());
            preparedStatement.setInt(4, assessment.getQuiz2());
            preparedStatement.setInt(5, assessment.getQuiz3());
            preparedStatement.setInt(6, assessment.getQuiz4());
            preparedStatement.setInt(7, assessment.getQuiz5());
            preparedStatement.setInt(8, assessment.getAssignment1());
            preparedStatement.setInt(9, assessment.getAssignment2());
            preparedStatement.setInt(10, assessment.getAssignment3());
            preparedStatement.setInt(11, assessment.getMidExam());
            preparedStatement.setInt(12, assessment.getFinalExam());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Assessment selectAssessment(int id) {
        Assessment assessment = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSESSMENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int assessmentId = rs.getInt("assessmentId");
                int studentId = rs.getInt("studentId");
                String courseCode = rs.getString("courseCode");
                int quiz1 = rs.getInt("quiz1");
                int quiz2 = rs.getInt("quiz2");
                int quiz3 = rs.getInt("quiz3");
                int quiz4 = rs.getInt("quiz4");
                int quiz5 = rs.getInt("quiz5");
                int assignment1 = rs.getInt("assignment1");
                int assignment2 = rs.getInt("assignment2");
                int assignment3 = rs.getInt("assignment3");
                int midExam= rs.getInt("midExam");
                int finalExam= rs.getInt("finalExam");
                assessment = new Assessment(assessmentId,studentId,courseCode,quiz1,quiz2,quiz3,quiz4,quiz5,
                        assignment1,assignment2,assignment3,midExam,finalExam);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return assessment;
    }

    public List<Assessment> selectAllAssessments() {

        List<Assessment> assessments = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSESSMENTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int assessmentId = rs.getInt("assessmentId");
                int studentId = rs.getInt("studentId");
                String courseCode = rs.getString("courseCode");
                int quiz1 = rs.getInt("quiz1");
                int quiz2 = rs.getInt("quiz2");
                int quiz3 = rs.getInt("quiz3");
                int quiz4 = rs.getInt("quiz4");
                int quiz5 = rs.getInt("quiz5");
                int assignment1 = rs.getInt("assignment1");
                int assignment2 = rs.getInt("assignment2");
                int assignment3 = rs.getInt("assignment3");
                int midExam= rs.getInt("midExam");
                int finalExam= rs.getInt("finalExam");
                assessments.add(new Assessment(assessmentId,studentId,courseCode,quiz1,quiz2,quiz3,quiz4,quiz5,
                        assignment1,assignment2,assignment3,midExam,finalExam));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return assessments;
    }

    public boolean deleteAssessment(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ASSESSMENT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateAssessment(Assessment assessment) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ASSESSMENT);) {
            System.out.println("updated Assessment:"+preparedStatement);
            preparedStatement.setInt(1,  assessment.getStudentId());
            preparedStatement.setString(2, assessment.getCourseCode());
            preparedStatement.setInt(3, assessment.getQuiz1());
            preparedStatement.setInt(4, assessment.getQuiz2());
            preparedStatement.setInt(5, assessment.getQuiz3());
            preparedStatement.setInt(6, assessment.getQuiz4());
            preparedStatement.setInt(7, assessment.getQuiz5());
            preparedStatement.setInt(8, assessment.getAssignment1());
            preparedStatement.setInt(9, assessment.getAssignment2());
            preparedStatement.setInt(10, assessment.getAssignment3());
            preparedStatement.setInt(11, assessment.getMidExam());
            preparedStatement.setInt(12, assessment.getFinalExam());
            preparedStatement.setInt(13, assessment.getAssessmentId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
