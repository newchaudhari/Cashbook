<%@ page import="controller.income_controller.IncomeController" %>
<%@ page import="model.Income" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Expense" %>
<%@ page import="controller.expense_controller.ExpenseController" %>
<%@ page import="constants.DBConstants" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expense</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1000px;
            margin: 100px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 5px;
            border: 5px groove black;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
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

        .button.delete {
            background-color: #dc3545;
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
            background-color: red;
            color: white;
        }
        .center{
            font-family: "Times New Roman", Times, serif;
            text-align: center;
            color: black;
        }

        .top-right-button {
            position: fixed;
            top: 20px;
            right: 20px;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            color: #fff;
            background-color: #007bff;
            cursor: pointer;
            z-index: 9999; /* Ensure the button is above other content */
        }

        /* Additional styles to make it more attractive */
        .top-right-button:hover {
            background-color: #0056b3;
            transform: scale(1.05); /* Add a slight scale effect on hover */
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .btn{
            margin: auto;
            width: 50%;
            padding: 10px;
        }.topnav .search-container {
             float: right;
         }

        .topnav input[type=text] {
            padding: 6px;
            margin-top: 8px;
            font-size: 17px;
            border: 2px solid black;
        }

        .topnav .search-container button {
            float: right;
            padding: 6px 10px;
            margin-top: 8px;
            margin-right: 16px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }

        .topnav .search-container button:hover {
            background: #ccc;
        }

        @media screen and (max-width: 600px) {
            .topnav .search-container {
                float: none;
            }
            .topnav a, .topnav input[type=text], .topnav .search-container button {
                float: none;
                display: block;
                text-align: left;
                width: 100%;
                margin: 0;
                padding: 14px;
            }
            .topnav input[type=text] {
                border: 1px solid #ccc;
            }
        }
    </style>
</head>
<body>

<%
    Object id = session.getAttribute("id");
    int user_id = (Integer) id;
   ExpenseController expenseController=new ExpenseController();
    List<Expense> allExpenses = expenseController.getAllExpenses(user_id);

    int totalExpense=0;
    for (Expense expense : allExpenses) {
        int amount = expense.getAmount();
       totalExpense += amount;
    }
%>
<div class="container">
    <h1 class="center">Expense Details</h1>
    <div class="topnav">
        <div class="search-container">
            <form action="expense_filter">
                <input type="text" placeholder="Date..." name="date">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
    </div>
    <br>
    <br>
    <table>
        <thead>
        <tr>
            <th>Expense Id</th>
            <th>Date</th>
            <th>Time</th>
            <th>Remarks</th>
            <th>Category</th>
            <th>Payment Mode</th>
            <th>Amount</th>
        </tr>
        </thead>
        <%
            for (Expense expense : allExpenses) {
        %>
        <tbody>
        <tr>
            <td>
                <%=
                expense.getId()
                %>
            </td>
            <td>
                <%=
                expense.getDate()
                %>
            </td>
            <td>
                <%=
                expense.getTime()
                %>
            </td>
            <td>
                <%=
                expense.getRemarks()
                %>
            </td>
            <td>
                <%=
                expense.getCategory()
                %>
            </td>
            <td>
                <%=
                expense.getPaymentMode()
                %>
            </td>
            <td>
                <%=
                expense.getAmount()
                %>
            </td>

        </tr>
            <%
            }
        %>
        <tfoot>
        <tr>
            <td colspan="4" style="text-align: center">
                Total Expense
            </td>
            <td colspan="3" style="text-align: center">
                <%=
                totalExpense
                %>
            </td>
        </tr>
        </tfoot>
        </tbody>
    </table>

    <div class="btn">
        <a class="button" href="expense_add.jsp">Add</a>
        <a class="button" href="expense_update.jsp">Update</a>
        <a class="button" href="expense_details.jsp">Check Expense</a>
        <button class="top-right-button"><a href="welcome.jsp"><i class="fa fa-home"></i></a></button>
        <a class="button delete" href="expense_delete.jsp">Delete</a>
    </div>
</div>
</body>
</html>
