package controller.income_controller;

import model.Income;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;


@WebServlet("/income_update")
public class UpdateIncome extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        IncomeController incomeController=new IncomeController();
        req.getSession(false);
        int income_id = Integer.parseInt(req.getParameter("id"));

        String date = req.getParameter("date");
        Date date1= Date.valueOf(date);//converting string into sql date

        String time = req.getParameter("time");
        Time time1=Time.valueOf(time);//converting string into sql time

        int amount = Integer.parseInt(req.getParameter("amount"));
        String remark = req.getParameter("remark");
        String category = req.getParameter("category");
        String payment = req.getParameter("payment");

        Income income = new Income();
        income.setId(income_id);
        income.setDate(date1);
        income.setTime(time1);
        income.setAmount(amount);
        income.setRemarks(remark);
        income.setCategory(category);
        income.setPaymentMode(payment);


        incomeController.editIncome(income);

        PrintWriter writer = resp.getWriter();
        writer.println("<center><h1 style=\"color: black\">Income updated successfully</h1></center>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("income.jsp");
        requestDispatcher.include(req, resp);
    }
}
