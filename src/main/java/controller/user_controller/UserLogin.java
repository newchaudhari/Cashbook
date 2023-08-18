package controller.user_controller;

import dao.UserDao;
import model.User;
import utils.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpSession session = req.getSession(true);


        UserDao userDao=new UserDao();
        ResultSet resultSet = userDao.verifyUser(user);
        try {
            if (resultSet.next()){
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                session.setAttribute("id",id);
                session.setAttribute("name",name);
                session.setAttribute("email",email);
                session.setAttribute("phone",phone);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcome.jsp");
                requestDispatcher.include(req,resp);
            }else {
                writer.println("<center><h1 style=\"color: darkred\">Invalid Credentials</h1></center>");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.include(req,resp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Connection connection = DBUtils.getConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
