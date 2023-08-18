package controller.expense_controller;



import model.Expense;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/expense_add")
public class AddExpense extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ExpenseController expenseController=new ExpenseController();
        HttpSession session = req.getSession(false);

        String date = req.getParameter("date");
        java.sql.Date date1= Date.valueOf(date);//converting string into sql date

        String time = req.getParameter("time");
        Time time1=Time.valueOf(time);//converting string into sql time

        int amount = Integer.parseInt(req.getParameter("amount"));
        String remark = req.getParameter("remark");
        String category = req.getParameter("category");
        String payment = req.getParameter("payment");

        Expense expense = new Expense();
        expense.setDate(date1);
        expense.setTime(time1);
        expense.setAmount(amount);
        expense.setRemarks(remark);
        expense.setCategory(category);
        expense.setPaymentMode(payment);
        Object userId = session.getAttribute("id");
        int id=(Integer) userId;
        expense.setUserId(id);

        expenseController.addExpense(expense);

        PrintWriter writer = resp.getWriter();
        writer.println("<center><h1 style=\"color: black\">Expense added successfully</h1></center>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("expense.jsp");
        requestDispatcher.include(req, resp);
    }
}
