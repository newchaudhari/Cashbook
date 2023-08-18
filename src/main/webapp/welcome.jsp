<%@ page import="model.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="controller.income_controller.IncomeController" %>
<%@ page import="model.Income" %>
<%@ page import="controller.expense_controller.ExpenseController" %>
<%@ page import="model.Expense" %>
<%@ page import="service.UserService" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cashbook</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            color: #fff;
            background-color: #007bff;
            cursor: pointer;
        }

        .button.logout {
            background-color: #dc3545;
        }

        .container {
            max-width: 1000px;
            margin: 100px auto;
            padding: 30px;
            background-color: #fff;
           border: 5px groove black;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            margin: 25px auto;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #44aeea;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #cce7ff;
        }

        tfoot {
            background-color: green;
            color: black;
        }

        .center {
            font-family: "Times New Roman", Times, serif;
            text-align: center;
            color: black;
        }
        .btn {
            margin: auto;
            width: 50%;
            padding: 10px;
        }
        .userDetails{
            font-family: "Times New Roman", Times, serif;
            text-align: center;
            color: rgb(201, 120, 0);
        }
        span{
            color: red;
        }
        .tdColor{
            text-align: center;
            color: white;
        }

    </style>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("pragma","no-cache");
    response.setDateHeader("Expire",0);

%>
<div class="container">

    <h1 class="center"  style="font-size: 40px">Welcome to Cash<span>book</span></h1>

    <div class="userDetails">
        <h2 class="heading"> Id:
            <%=session.getAttribute("id")%>
        </h2>
        <h2 class="heading">Name:
            <%=session.getAttribute("name")%>
        </h2>
        <h2 class="heading">Email:
            <%=session.getAttribute("email")%>
        </h2>
        <h2 class="heading">Phone No:
            <%=session.getAttribute("phone")%>
        </h2>

    </div>
    <%
        request.getSession(false);
        UserService userService = new UserService();
        Object id = session.getAttribute("id");
        int user_id = (Integer) id;
        List<Transaction> transactions = userService.allTransaction(user_id);

        int totalIncome = 0;
        int totalExpense = 0;


        IncomeController incomeController = new IncomeController();
        List<Income> allIncomes = incomeController.getAllIncomes(user_id);
        for (Income income : allIncomes) {
            int amount = income.getAmount();
            totalIncome += amount;
        }
        controller.expense_controller.ExpenseController expenseController = new controller.expense_controller.ExpenseController();
        List<Expense> allExpenses = expenseController.getAllExpenses(user_id);

        for (Expense expense : allExpenses) {
            int amount = expense.getAmount();
            totalExpense += amount;
        }

        int totalBalance = totalIncome - totalExpense;
    %>
    <h1 class="center" >Account Statement</h1>

    <table>
        <thead>
        <tr>
            <th>Type</th>
            <th>Id</th>
            <th>Date</th>
            <th>Time</th>
            <th>Remarks</th>
            <th>Category</th>
            <th>Payment Mode</th>
            <th>Amount</th>
        </tr>
        </thead>
        <%
            for (Transaction transaction : transactions) {
        %>
        <tbody>
        <tr>

            <%
                String type = transaction.getType();
            %>

            <td>
                <%=
                type
                %>
            </td>
            <td>
                <%=
                transaction.getIncomeExpenseId()
                %>
            </td>
            <td>
                <%=
                transaction.getDate()
                %>
            </td>
            <td>
                <%=
                transaction.getTime()
                %>
            </td>
            <td>
                <%=
                transaction.getRemarks()
                %>
            </td>
            <td>
                <%=
                transaction.getCategory()
                %>
            </td>
            <td>
                <%=
                transaction.getPaymentMode()
                %>
            </td>
            <%
                if (type.equals("Income")) {
            %>
            <td style="color: green;">
                <%=
                transaction.getAmount()
                %>
            </td>
            <%
            } else if (type.equals("Expense")) {
            %>
            <td style="color: red;">
                <%=
                transaction.getAmount()
                %>
            </td>
            <%
                }
            %>

        </tr>
            <%
            }
        %>
        <tfoot>
        <tr>
            <td class="tdColor" colspan="6" >
                Total Balance
            </td>
            <td class="tdColor" colspan="2" >
                <%=
                totalBalance
                %>
            </td>
        </tr>
        </tfoot>
        </tbody>
    </table>

    <div class="btn">
        <a class="button" href="income.jsp">Income</a>
        <a class="button" href="expense.jsp">Expense</a>
        <a class="button logout" href="logout">Logout</a>
    </div>
</div>
</body>
</html>
