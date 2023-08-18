package dao;

import model.Expense;
import model.Income;
import utils.DBUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    public void addExpense(Expense expense) {
        Connection connection = DBUtils.getConnection();
        String query = "INSERT INTO expense (user_id,date,time,amount,remarks,category,payment_mode) VALUES  ((SELECT user_id FROM user WHERE user_id=?), ?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,expense.getUserId());
            preparedStatement.setDate(2,  expense.getDate());
            preparedStatement.setTime(3,expense.getTime());
            preparedStatement.setInt(4,expense.getAmount());
            preparedStatement.setString(5,expense.getRemarks());
            preparedStatement.setString(6,expense.getCategory());
            preparedStatement.setString(7,expense.getPaymentMode());
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

    public void editExpense(Expense expense) {
        Connection connection = DBUtils.getConnection();
        String query = "UPDATE expense SET date=?, time=?,amount=?, remarks=?, category=?, payment_mode=? WHERE expense_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, expense.getDate());
            preparedStatement.setTime(2,expense.getTime());
            preparedStatement.setInt(3,expense.getAmount());
            preparedStatement.setString(4,expense.getRemarks());
            preparedStatement.setString(5,expense.getCategory());
            preparedStatement.setString(6,expense.getPaymentMode());
            preparedStatement.setInt(7,expense.getId());
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

    public void deleteExpense(int id) {
        Connection connection = DBUtils.getConnection();
        String query="DELETE FROM expense WHERE expense_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Expense getExpenseById(int expenseId) {
        Expense expense=new Expense();
        Connection connection = DBUtils.getConnection();
        String query="SELECT * FROM expense WHERE expense_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,expenseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                expense.setId(resultSet.getInt("expense_id"));
                expense.setDate(resultSet.getDate("date"));
                expense.setTime(resultSet.getTime("time"));
                expense.setAmount(resultSet.getInt("amount"));
                expense.setRemarks(resultSet.getString("remarks"));
                expense.setCategory(resultSet.getString("category"));
                expense.setPaymentMode(resultSet.getString("payment_mode"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return expense;
    }

    public List<Expense> getAllExpense(int user_id) {
        List<Expense> expenseList=new ArrayList<Expense>();

        Connection connection = DBUtils.getConnection();
        String query="SELECT * FROM expense WHERE user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Expense expense=new Expense();
                expense.setId(resultSet.getInt("expense_id"));
                expense.setDate(resultSet.getDate("date"));
                expense.setTime(resultSet.getTime("time"));
                expense.setAmount(resultSet.getInt("amount"));
                expense.setRemarks(resultSet.getString("remarks"));
                expense.setCategory(resultSet.getString("category"));
                expense.setPaymentMode(resultSet.getString("payment_mode"));
                expenseList.add(expense);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return expenseList;
    }

    public List<Expense> filterExpense(Date date) {
        List<Expense> expenseList=new ArrayList<Expense>();

        Connection connection = DBUtils.getConnection();
        String query="SELECT * FROM expense WHERE date=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Expense expense=new Expense();
                expense.setId(resultSet.getInt("expense_id"));
                expense.setDate(resultSet.getDate("date"));
                expense.setTime(resultSet.getTime("time"));
                expense.setAmount(resultSet.getInt("amount"));
                expense.setRemarks(resultSet.getString("remarks"));
                expense.setCategory(resultSet.getString("category"));
                expense.setPaymentMode(resultSet.getString("payment_mode"));
                expenseList.add(expense);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return expenseList;
    }
}
