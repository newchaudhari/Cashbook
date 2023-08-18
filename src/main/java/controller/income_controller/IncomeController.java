package controller.income_controller;

import model.Income;
import service.IncomeService;

import java.sql.Date;
import java.util.List;

public class IncomeController {
    IncomeService incomeService = new IncomeService();

    public void addIncome(Income income) {
        incomeService.addIncome(income);
    }

    public void editIncome(Income income) {
        incomeService.editIncome(income);
    }

    public void deleteIncome(int id) {
        incomeService.deleteIncome(id);
    }

    public Income getIncomeById(int incomeId) {
        return incomeService.getIncomeById(incomeId);
    }

    public  List<Income> getAllIncomes(int user_id) {
        return incomeService.getAllIncomes(user_id);
    }

    public List<Income> filterIncomes(Date date) {
        return incomeService.filterIncomes(date);
    }
}
