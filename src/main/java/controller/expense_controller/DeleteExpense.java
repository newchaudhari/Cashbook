package controller.expense_controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/expense_delete")
public class DeleteExpense extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ExpenseController expenseController=new ExpenseController();
        req.getSession(false);
        int expense_id = Integer.parseInt(req.getParameter("id"));
        expenseController.deleteExpense(expense_id);

        PrintWriter writer = resp.getWriter();
        writer.println("<center><h1 style=\"color: green\">Expense details deleted successfully</h1></center>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("expense.jsp");
        requestDispatcher.include(req, resp);
    }
}
