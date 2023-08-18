package service;

import dao.ExpenseDao;
import model.Expense;
import model.Income;

import java.sql.Date;
import java.util.List;

public class ExpenseService {
    ExpenseDao expenseDao = new ExpenseDao();

    public void addExpense(Expense expense) {
        expenseDao.addExpense(expense);
    }

    public void editExpense(Expense expense) {
        expenseDao.editExpense(expense);
    }

    public void deleteExpense(int id) {
        expenseDao.deleteExpense(id);
    }

    public Expense getExpenseById(int expenseId) {
        return expenseDao.getExpenseById(expenseId);
    }

    public List<Expense> getAllExpenses(int user_id) {
        return expenseDao.getAllExpense(user_id);
    }

    public List<Expense> filterExpenses(Date date) {
        return expenseDao.filterExpense(date);
    }
}
