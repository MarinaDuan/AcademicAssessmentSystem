package DAO;

import model.Assessment;
import model.Criteria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CriteriaDAO extends DAO{

    private static final String SELECT_CRITERION_BY_ID="SELECT * FROM criteria WHERE criteriaId=?";
    private static final String INSERT_CRITERION="INSERT INTO criteria"+" (criteriaId,courseCode,quiz1,quiz2,quiz3," +
            "quiz4,quiz5,assignment1,assignment2,assignment3,midExam,finalExam) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_CRITERIA = "SELECT * FROM criteria";
    private static final String DELETE_CRITERION = "DELETE FROM criteria WHERE criteriaId=?;";
    private static final String UPDATE_CRITERION = "UPDATE criteria SET courseCode=?,quiz1=?,quiz2=?,quiz3=?,quiz4=?," +
            "quiz5=?,assignment1=?,assignment2=?,assignment3=?,midExam=?,finalExam=? WHERE criteriaId=?;";


    public Criteria selectCriterion(int criteria_Id){
        Criteria criterion=null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CRITERION_BY_ID)) {
            preparedStatement.setInt(1, criteria_Id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //criteriaId,courseCode,quiz1,quiz2,quiz3,quiz4,quiz5,assignment1,assignment2,assignment3,midExam,finalExam
            while (rs.next()) {
                int criteriaId = rs.getInt("criteriaId");
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
                criterion = new Criteria(criteriaId,courseCode,quiz1,quiz2,quiz3,quiz4,quiz5,assignment1,assignment2,
                        assignment3,midExam,finalExam);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return criterion;
    }

    public void insertCriteria(Criteria criterion) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CRITERION);){
            preparedStatement.setInt(1, criterion.getCriteriaId());
            preparedStatement.setString(2, criterion.getCourseCode());
            preparedStatement.setInt(3, criterion.getQuiz1());
            preparedStatement.setInt(4, criterion.getQuiz2());
            preparedStatement.setInt(5, criterion.getQuiz3());
            preparedStatement.setInt(6, criterion.getQuiz4());
            preparedStatement.setInt(7, criterion.getQuiz5());
            preparedStatement.setInt(8, criterion.getAssignment1());
            preparedStatement.setInt(9, criterion.getAssignment2());
            preparedStatement.setInt(10, criterion.getAssignment3());
            preparedStatement.setInt(11, criterion.getMidExam());
            preparedStatement.setInt(12, criterion.getFinalExam());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public List<Criteria> selectAllCriteria() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Criteria> criteria = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CRITERIA);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int criteriaId = rs.getInt("criteriaId");
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
                criteria.add(new Criteria(criteriaId,courseCode,quiz1,quiz2,quiz3,quiz4,quiz5,assignment1,assignment2,
                        assignment3,midExam,finalExam));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return criteria;
    }

    public boolean deleteCriteria(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CRITERION);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateCriteria(Criteria criterion) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CRITERION);) {
            System.out.println("updated Criterion:"+preparedStatement);
            preparedStatement.setString(1, criterion.getCourseCode());
            preparedStatement.setInt(2, criterion.getQuiz1());
            preparedStatement.setInt(3, criterion.getQuiz2());
            preparedStatement.setInt(3, criterion.getQuiz3());
            preparedStatement.setInt(4, criterion.getQuiz4());
            preparedStatement.setInt(5, criterion.getQuiz5());
            preparedStatement.setInt(6, criterion.getAssignment1());
            preparedStatement.setInt(7, criterion.getAssignment2());
            preparedStatement.setInt(8, criterion.getAssignment3());
            preparedStatement.setInt(9, criterion.getMidExam());
            preparedStatement.setInt(10, criterion.getFinalExam());
            preparedStatement.setInt(11, criterion.getCriteriaId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }



}
