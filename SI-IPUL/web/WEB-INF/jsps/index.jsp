<%-- 
    Document   : index
    Created on : 16 Nov 11, 23:00:04
    Author     : yogi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to SiIpul</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method ="post" action="login">
            <fieldset>
            Username:
            <input type="text" name="username" />
            <br><br>
            Password:
            <input type="password" name="password" />
            <br><br>
            <input type="submit" name="Login " />
            </fieldset>
        </form>
        <a href="register">Register</a>
    </body>
</html>
