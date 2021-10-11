<%-- 
    Document   : login
    Created on : Oct 11, 2021, 2:44:55 PM
    Author     : 851649
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="POST"> 
            <label>Username:</label>
            <input type="text" name="username_input">
            <br>
            <label>Password:</label>
            <input type="text" name="password_input">
            <br>
            <input type="submit" name="login_submit" value="Log in">
        </form>
        
        <p>${message}</p>
    </body>
</html>
