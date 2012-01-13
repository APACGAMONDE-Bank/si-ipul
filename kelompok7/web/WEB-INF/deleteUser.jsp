<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete User SI-IPUL</title>
    </head>
    <body>
        <h2><%=(request.getAttribute("message"))%></h2>
        <form action="delete-user" method="POST">
            <label>Username : </label><br />
            <input type="text" name="username" value="" /> <input type="hidden" name="act" value="add" /> <br />
            <input type="submit" value="Delete" />
        </form><br/>
    </body>
</html>
