package controller.income_controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/income_delete")
public class DeleteIncome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        IncomeController incomeController=new IncomeController();
        req.getSession(false);
        int income_id = Integer.parseInt(req.getParameter("id"));
        incomeController.deleteIncome(income_id);

        PrintWriter writer = resp.getWriter();
        writer.println("<center><h1 style=\"color: green\">Income details deleted successfully</h1></center>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("income.jsp");
        requestDispatcher.include(req, resp);
    }
}
