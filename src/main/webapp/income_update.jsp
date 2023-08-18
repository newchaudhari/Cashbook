<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Income</title>
    <!---Custom CSS File--->
    <link rel="stylesheet" href="income style.css">
</head>
<body>
<div class="container">
    <input type="checkbox" id="check">
    <div class="form">
        <header>Income</header>
        <form action="income_update" method="post">
            <input type="number" placeholder="Enter your income Id" name="id">
            <input type="text" placeholder="Date YYYY-MM-DD" name="date">
            <input type="text" placeholder="Time HH:MM:SS" name="time">
            <input type="number" placeholder="Enter Amount" name="amount">
            <input type="text" placeholder="Remark" name="remark">
            <input type="text" placeholder="Category" name="category">
            <input type="text" placeholder="Payment Mode" name="payment">

            <input type="submit" class="button" value="Update Income">
        </form>

    </div>
</div>
</body>
</html>