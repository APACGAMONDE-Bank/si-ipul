<%-- 
    Document   : register2
    Created on : Nov 27, 2011, 10:16:09 PM
    Author     : yogi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <h2>Edit Profile</h2>
        <br>
        <form method="post" action="editProfil">
            <fieldset>
                Nama :
                <input type="text" name="name" />
                <br><br>
                Alamat :
                <input type="text" name="address" />
                <br><br>
                Telepon :
                <input type="text" name="phone" />
                <br><br>
                Email :
                <input type="text" name="email" />
                <br><br>
                Username :
                <input type="text" name="username" />
                <br><br>
                Password :
                <input type="password" name="password" />
                <br><br>
                Confirm Password :
                <input type="password" name="confirm password" />
                <br><br>
                <input type="submit" value="Register" />
            </fieldset>
        </form>
        <a href="login">Back to Login Page</a>
    </body>
</html>
