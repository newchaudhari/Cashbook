package service;

import dao.IncomeDao;
import model.Income;

import java.sql.Date;
import java.util.List;

public class IncomeService {
    IncomeDao incomeDao = new IncomeDao();

    public void addIncome(Income income) {
        incomeDao.addIncome(income);
    }

    public void editIncome(Income income) {
        incomeDao.editIncome(income);
    }

    public void deleteIncome(int id) {
        incomeDao.deleteIncome(id);
    }

    public Income getIncomeById(int incomeId) {
        return incomeDao.getIncomeById(incomeId);
    }

    public  List<Income> getAllIncomes(int user_id) {
        return incomeDao.getAllIncomes(user_id);
    }

    public List<Income> filterIncomes(Date date) {
        return incomeDao.filterIncomes(date);
    }
}
