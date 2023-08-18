package service;

import dao.UserDao;
import model.Transaction;
import model.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public List<Transaction> allTransaction(int user_id){
        return userDao.allTransaction(user_id);
    }
}
