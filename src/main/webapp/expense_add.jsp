<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Expense</title>
    <!---Custom CSS File--->
    <link rel="stylesheet" href="income style.css">
</head>
<body>
<div class="container">
    <input type="checkbox" id="check">
    <div class="form">
        <header>Expense</header>
        <form action="expense_add" method="post">
            <%--      <input type="number" placeholder="Enter your userId" name="id">--%>
            <input type="text" placeholder="Date YYYY-MM-DD" name="date">
            <input type="text" placeholder="Time HH:MM:SS" name="time">
            <input type="number" placeholder="Enter Amount" name="amount">
            <input type="text" placeholder="Remark" name="remark">
            <input type="text" placeholder="Category" name="category">
            <input type="text" placeholder="Payment Mode" name="payment">

            <input type="submit" class="button" value="Add Expense">
        </form>

    </div>
</div>
</body>
</html>