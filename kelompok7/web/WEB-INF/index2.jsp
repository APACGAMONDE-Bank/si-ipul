<%@page import="entity.infoBerita"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to SiIpul</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Judul</th>
                    <th>Info</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<infoBerita> i = (Iterator<infoBerita>) request.getAttribute("daftar_berita");
                int no = 0;
                while(i.hasNext()){
                    infoBerita ib= i.next();
                    no++;
                %>
                
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(ib.getTitle())%></td>
                    <td><%=(ib.getInfoBerita())%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
            <a href="login">Member</a>
            <a href="loginAd">Admin</a>
        <h1>Login</h1>
        <form method ="post" action="loginOp">
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
