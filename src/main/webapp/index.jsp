<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cashbook</title>
    <!---Custom CSS File--->
    <link rel="stylesheet" href="form.css">
</head>
<body>
<div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
        <header>Login</header>
        <form action="login" method="post">
            <input type="text" placeholder="Enter your username" name="username">
            <input type="password" placeholder="Enter your password" name="password">
            <a href="#">Forgot password?</a>
            <input type="submit" class="button" value="Login">
        </form>
        <div class="signup">
        <span class="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
        </div>
    </div>
    <div class="registration form">
        <header>Signup</header>
        <form action="signup" method="post">
            <input type="text" placeholder="Enter your name" name="name" required>
            <input type="text" placeholder="Enter your username" name="username" required>
            <input type="password" placeholder="Create a password" name="password"
                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                   required>
            <input type="email" placeholder="Enter your email" name="email" required>
            <input type="number" placeholder="Enter your phone" name="phone" required>

            <input type="submit" class="button" value="Signup">
        </form>
        <div class="signup">
        <span class="signup">Already have an account?
         <label for="check">Login</label>
        </span>
        </div>
    </div>
</div>
</body>
</html>