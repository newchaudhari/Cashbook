package dao;

import model.Income;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDao {
    public void addIncome(Income income) {
        Connection connection = DBUtils.getConnection();
        String query = "INSERT INTO income (user_id,date,time,amount,remarks,category,payment_mode) VALUES  ((SELECT user_id FROM user WHERE user_id=?), ?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,income.getUserId());
            preparedStatement.setDate(2, income.getDate());
            preparedStatement.setTime(3,income.getTime());
            preparedStatement.setInt(4,income.getAmount());
            preparedStatement.setString(5,income.getRemarks());
            preparedStatement.setString(6,income.getCategory());
            preparedStatement.setString(7,income.getPaymentMode());
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

    public void editIncome(Income income) {
        Connection connection = DBUtils.getConnection();
        String query = "UPDATE income SET date=?, time=?,amount=?, remarks=?, category=?, payment_mode=? WHERE income_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, income.getDate());
            preparedStatement.setTime(2,income.getTime());
            preparedStatement.setInt(3,income.getAmount());
            preparedStatement.setString(4,income.getRemarks());
            preparedStatement.setString(5,income.getCategory());
            preparedStatement.setString(6,income.getPaymentMode());
            preparedStatement.setInt(7,income.getId());
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

    public void deleteIncome(int id) {
        Connection connection = DBUtils.getConnection();
        String query="DELETE FROM income WHERE income_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Income getIncomeById(int incomeId) {
        Income income=new Income();
        Connection connection = DBUtils.getConnection();
        String query="SELECT * FROM income WHERE income_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,incomeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               income.setId(resultSet.getInt("income_id"));

               income.setDate(resultSet.getDate("date"));
               income.setTime(resultSet.getTime("time"));
               income.setAmount(resultSet.getInt("amount"));
               income.setRemarks(resultSet.getString("remarks"));
               income.setCategory(resultSet.getString("category"));
               income.setPaymentMode(resultSet.getString("payment_mode"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return income;
    }

    public List<Income> getAllIncomes(int user_id) {
        List<Income> incomeList=new ArrayList<Income>();

        Connection connection = DBUtils.getConnection();
        String query="SELECT * FROM income WHERE user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Income income=new Income();
                income.setId(resultSet.getInt("income_id"));
                income.setDate(resultSet.getDate("date"));
                income.setTime(resultSet.getTime("time"));
                income.setAmount(resultSet.getInt("amount"));
                income.setRemarks(resultSet.getString("remarks"));
                income.setCategory(resultSet.getString("category"));
                income.setPaymentMode(resultSet.getString("payment_mode"));
                incomeList.add(income);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return incomeList;
    }


    public List<Income> filterIncomes(Date date) {
        List<Income> incomeList=new ArrayList<Income>();

        Connection connection = DBUtils.getConnection();
        String query="SELECT * FROM income WHERE date=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Income income=new Income();
                income.setId(resultSet.getInt("income_id"));
                income.setDate(resultSet.getDate("date"));
                income.setTime(resultSet.getTime("time"));
                income.setAmount(resultSet.getInt("amount"));
                income.setRemarks(resultSet.getString("remarks"));
                income.setCategory(resultSet.getString("category"));
                income.setPaymentMode(resultSet.getString("payment_mode"));
                incomeList.add(income);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return incomeList;
    }
}
