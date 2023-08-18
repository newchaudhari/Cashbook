package controller.expense_controller;

import model.Expense;
import service.ExpenseService;

import java.sql.Date;
import java.util.List;

public class ExpenseController {
    ExpenseService expenseService=new ExpenseService();
    public void addExpense(Expense expense) {
        expenseService.addExpense(expense);
    }

    public void editExpense(Expense expense) {
        expenseService.editExpense(expense);
    }

    public void deleteExpense(int id) {
        expenseService.deleteExpense(id);
    }

    public Expense getExpenseById(int expenseId) {
        return expenseService.getExpenseById(expenseId);
    }

    public List<Expense> getAllExpenses(int user_id) {
        return expenseService.getAllExpenses(user_id);
    }

    public List<Expense> filterExpenses(Date date) {
        return expenseService.filterExpenses(date);
    }
}
