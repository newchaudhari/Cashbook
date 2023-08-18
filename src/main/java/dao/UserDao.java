package dao;

import model.Income;
import model.Transaction;
import model.User;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void addUser(User user) {
        Connection connection=null;
        try {
            connection = DBUtils.getConnection();
            String sqlQuery="INSERT INTO user(name,username,password,email,phone) VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getPhone());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public ResultSet verifyUser(User user) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            String sqlQuery = "SELECT user_id,name,email,phone FROM user WHERE username=? AND password=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;

    }
    public List<Transaction> allTransaction(int user_id) {
        List<Transaction> transactions=new ArrayList<Transaction>();

        Connection connection = DBUtils.getConnection();
        String query= " SELECT 'Income' AS type, income_id AS income_id, date, time, amount, remarks, category, payment_mode, NULL AS expense_id " +
                "                              FROM income " +
                "                              WHERE user_id = ? " +
                "                              UNION ALL " +
                "                              SELECT 'Expense' AS type, NULL AS income_id, date, time, amount, remarks, category, payment_mode, expense_id " +
                "                              FROM expense" +
                "                              WHERE user_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setType(resultSet.getString("type"));
                transaction.setIncomeExpenseId(resultSet.getInt("income_id"));
                transaction.setDate(resultSet.getDate("date"));
                transaction.setTime(resultSet.getTime("time"));
                transaction.setAmount(resultSet.getInt("amount"));
                transaction.setRemarks(resultSet.getString("remarks"));
                transaction.setCategory(resultSet.getString("category"));
                transaction.setPaymentMode(resultSet.getString("payment_mode"));

                int expense_id = resultSet.getInt("expense_id");
                if (!resultSet.wasNull()) {
                    transaction.setIncomeExpenseId(expense_id);
                }

                transactions.add(transaction);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }
}
