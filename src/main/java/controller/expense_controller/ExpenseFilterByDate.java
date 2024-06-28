package controller.expense_controller;

import model.Expense;
import model.Income;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/expense_filter")
public class ExpenseFilterByDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        req.getSession(false);

        String date = req.getParameter("date");
        Date date1=Date.valueOf(date);

        ExpenseController expenseController=new ExpenseController();
        List<Expense> expenseList = expenseController.filterExpenses(date1);

        writer.println("     <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "<style> body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f2f2f2;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        .button {\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 20px;\n" +
                "            margin: 10px;\n" +
                "            font-size: 16px;\n" +
                "            border: none;\n" +
                "            border-radius: 5px;\n" +
                "            color: #fff;\n" +
                "            background-color: #007bff;\n" +
                "            cursor: pointer;\n" +
                "        }\n" +

                "        table {\n" +
                "            width: 80%;\n" +
                "            margin: 20px auto;\n" +
                "            border-collapse: collapse;\n" +
                "            border-radius: 8px;\n" +
                "            overflow: hidden;\n" +
                "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "            background-color: #fff;\n" +
                "        }\n" +
                "\n" +
                "        th, td {\n" +
                "            padding: 12px;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "\n" +
                "        th {\n" +
                "            background-color: #44aeea;\n" +
                "            color: #fff;\n" +
                "        }\n" +
                "\n" +
                "        tr:nth-child(even) {\n" +
                "            background-color: #f2f2f2;\n" +
                "        }\n" +
                "\n" +
                "        tr:hover {\n" +
                "            background-color: #cce7ff;\n" +
                "        }" + " .top-right-button {\n" +
                "            position: fixed;\n" +
                "            top: 20px;\n" +
                "            right: 20px;\n" +
                "            padding: 10px 20px;\n" +
                "            font-size: 16px;\n" +
                "            border: none;\n" +
                "            border-radius: 5px;\n" +
                "            color: #fff;\n" +
                "            background-color: #007bff;\n" +
                "            cursor: pointer;\n" +
                "            z-index: 9999; /* Ensure the button is above other content */\n" +
                "        }\n" +
                "\n" +
                "        /* Additional styles to make it more attractive */\n" +
                "        .top-right-button:hover {\n" +
                "            background-color: #0056b3;\n" +
                "            transform: scale(1.05); /* Add a slight scale effect on hover */\n" +
                "            transition: background-color 0.3s ease, transform 0.3s ease;\n" +
                "        }\n" +
                "\n" +
                "        .btn {\n" +
                "            margin: auto;\n" +
                "            width: 50%;\n" +
                "            padding: 10px;\n" +
                "        }" +
                " </style>");
        writer.println("<center><h1>Expense Details</h1></center>");
        writer.print("<table ><thead>");
        writer.println("<tr>" +
                "                <th>Income Id</th>" +
                "                <th>Date</th>" +
                "                <th>Time</th>" +
                "                <th>Remarks</th>" +
                "                <th>Category</th>" +
                "                <th>Payment Mode</th>" +
                "                <th>Amount</th>" +
                "            </tr></thead>");
        for (Expense expense : expenseList) {

            writer.println("<tbody><tr>" + "<td>" + expense.getId() + "</td>"
                    + "<td>" + expense.getDate() + "</td>"
                    + "<td>" + expense.getTime() + "</td>"
                    + "<td>" + expense.getRemarks() + "</td>" +
                    "<td>" + expense.getCategory() + "</td>" +
                    "<td>" + expense.getPaymentMode() + "</td>" +
                    "<td>" + expense.getAmount() + "</td>" +
                    "</tr>");
        }
        writer.println("</tbody></table>");

        writer.println("  <div class=\"container\">\n" +
                "        <div class=\"btn\">\n" +
                "            <button class=\"top-right-button\"><a href=\"welcome.jsp\"><i class=\"fa fa-home\"></i></a></button>\n" +
                "        </div>\n" +
                "    </div>");

    }
}
